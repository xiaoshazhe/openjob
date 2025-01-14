package io.openjob.worker.util;

import io.openjob.worker.config.OpenjobConfig;
import io.openjob.worker.constant.WorkerConstant;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
public class OpenjobConfigUtil {
    public static Integer getDelayPullSize() {
        return OpenjobConfig.getInteger(WorkerConstant.WORKER_DELAY_PULL_SIZE, WorkerConstant.DEFAULT_WORKER_DELAY_PULL_SIZE);
    }

    public static Long getDelayPullSleep() {
        return OpenjobConfig.getLong(WorkerConstant.WORKER_DELAY_PULL_SLEEP, WorkerConstant.DEFAULT_WORKER_DELAY_PULL_SLEEP);

    }

    public static Long getDelayPullStep() {
        return OpenjobConfig.getLong(WorkerConstant.WORKER_DELAY_PULL_STEP, WorkerConstant.DEFAULT_WORKER_DELAY_PULL_STEP);
    }
}
