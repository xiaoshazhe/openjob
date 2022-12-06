package io.openjob.server.cluster.manager;

import com.google.common.collect.Maps;
import io.openjob.common.context.Node;
import io.openjob.server.cluster.autoconfigure.ClusterProperties;
import io.openjob.server.cluster.dto.NodeFailDTO;
import io.openjob.server.cluster.util.ClusterUtil;
import io.openjob.server.common.ClusterContext;
import io.openjob.server.repository.constant.ServerStatusEnum;
import io.openjob.server.repository.dao.JobSlotsDAO;
import io.openjob.server.repository.dao.ServerDAO;
import io.openjob.server.repository.entity.JobSlots;
import io.openjob.server.repository.entity.Server;
import io.openjob.server.scheduler.Scheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
@Component
@Slf4j
public class FailManager {
    private final ServerDAO serverDAO;
    private final JobSlotsDAO jobSlotsDAO;
    private final ClusterProperties clusterProperties;
    private final RefreshManager refreshManager;
    private final Scheduler scheduler;

    @Autowired
    public FailManager(ServerDAO serverDAO, JobSlotsDAO jobSlotsDAO, ClusterProperties clusterProperties, RefreshManager refreshManager, Scheduler scheduler) {
        this.serverDAO = serverDAO;
        this.jobSlotsDAO = jobSlotsDAO;
        this.clusterProperties = clusterProperties;
        this.refreshManager = refreshManager;
        this.scheduler = scheduler;
    }

    /**
     * Node fail.
     *
     * @param stopNode stopNode
     */
    @Transactional(rollbackFor = Exception.class)
    public void fail(Node stopNode, Boolean isShutDown) {
        // Update server status.
        this.serverDAO.update(stopNode.getServerId(), ServerStatusEnum.FAIL.getStatus());
        log.info("Update server to fail status {}", stopNode.getServerId());

        // Migrate slots.
        this.migrateSlots(stopNode);

        // Refresh system.
        this.refreshManager.refreshSystem(true);

        // Not shutdown.
        if (!isShutDown) {
            // Refresh nodes.
            this.refreshManager.refreshClusterNodes();

            // Refresh slots.
            this.refreshManager.refreshCurrentSlots();

            // Refresh scheduler.
            this.scheduler.refresh(Collections.emptySet());
        }

        // Akka message for stop.
        this.sendClusterStopMessage(stopNode, isShutDown);
    }

    /**
     * Migrate slots.
     *
     * @param stopNode stopNode
     */
    private void migrateSlots(Node stopNode) {
        List<JobSlots> currentJobSlots = this.jobSlotsDAO.listJobSlotsByServerId(stopNode.getServerId());
        List<Server> servers = this.serverDAO.listServers(ServerStatusEnum.OK.getStatus());

        // Exclude current server.
        int serverCount = servers.size();

        // Only one server.
        if (serverCount == 0) {
            jobSlotsDAO.updateByServerId(0L);
            log.info("Migrate slots to 0");
            return;
        }

        int index = 0;
        int slotsSize = (int) Math.floor((double) currentJobSlots.size() / serverCount);

        Map<Long, List<Long>> migrationSlots = Maps.newHashMap();
        for (int i = 0; i < servers.size(); i++) {
            Server s = servers.get(i);

            // Ignore current server.
            if (s.getId().equals(stopNode.getServerId())) {
                break;
            }

            // Last server.
            if (i + 1 == servers.size()) {
                List<Long> lastSlotsId = currentJobSlots.subList(index, currentJobSlots.size() - index)
                        .stream()
                        .map(JobSlots::getId)
                        .collect(Collectors.toList());
                migrationSlots.put(s.getId(), lastSlotsId);
                break;
            }

            index += slotsSize;

            List<Long> slotIds = currentJobSlots.subList(index, slotsSize)
                    .stream()
                    .map(JobSlots::getId)
                    .collect(Collectors.toList());
            migrationSlots.put(s.getId(), slotIds);
        }

        migrationSlots.forEach(this.jobSlotsDAO::updateByServerId);
        log.info("Migration slots {}", migrationSlots);
    }

    /**
     * Send cluster stop message.
     *
     * @param stopNode   stopNode
     * @param isShutDown is shutdown
     */
    private void sendClusterStopMessage(Node stopNode, Boolean isShutDown) {
        NodeFailDTO failDTO = new NodeFailDTO();
        failDTO.setClusterVersion(ClusterContext.getSystem().getClusterVersion());
        failDTO.setIp(stopNode.getIp());
        failDTO.setServerId(stopNode.getServerId());
        failDTO.setAkkaAddress(stopNode.getAkkaAddress());

        // Exclude current node.
        Set<Long> excludeNodes = new HashSet<>();
        if (!isShutDown) {
            excludeNodes.add(ClusterContext.getCurrentNode().getServerId());
        }

        Boolean result = ClusterUtil.sendMessage(failDTO, stopNode, this.clusterProperties.getSpreadSize(), excludeNodes);
        if (!result) {
            throw new RuntimeException("Send node fail message error!");
        }
    }
}
