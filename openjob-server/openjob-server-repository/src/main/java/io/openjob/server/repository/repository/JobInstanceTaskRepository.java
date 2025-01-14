package io.openjob.server.repository.repository;

import io.openjob.server.repository.entity.JobInstanceTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
public interface JobInstanceTaskRepository extends JpaRepository<JobInstanceTask, Long> {
}
