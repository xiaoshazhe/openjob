package io.openjob.server.cluster.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
@Data
public class WorkerJoinDTO implements Serializable {

    /**
     * Cluster version.
     */
    private Long clusterVersion;
}