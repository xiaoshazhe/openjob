package io.openjob.server.scheduler.util;


import io.openjob.server.scheduler.constant.CacheConst;

/**
 * @author stelin <swoft@qq.com>
 * @since 1.0.0
 */
public class CacheUtil {
    public static String getTopicListKey(String topic) {
        return String.format("%s:%s", CacheConst.TOPIC_LIST_PREFIX, topic);
    }

    public static String getDelayDetailTopicKey(String topic) {
        return String.format("%s:%s", CacheConst.DELAY_DETAIL_TOPIC_PREFIX, topic);
    }

    public static String getDelayDetailTaskIdKey(String taskId) {
        return String.format("%s:%s", CacheConst.DELAY_DETAIL_TASKID_PREFIX, taskId);
    }

    public static String getZsetKey(Long slotId) {
        return String.format("%s:%d", CacheConst.DELAY_ZSET_PREFIX, slotId);
    }

    public static String getAddListKey(Long slotId) {
        return String.format("%s:%d", CacheConst.DELAY_ADD_LIST_PREFIX, slotId);
    }

    public static String getStatusListKey(Long slotId) {
        return String.format("%s:%d", CacheConst.DELAY_STATUS_LIST_PREFIX, slotId);
    }

    public static String getDeleteListKey(Long slotId) {
        return String.format("%s:%d", CacheConst.DELAY_DELETE_LIST_PREFIX, slotId);
    }
}
