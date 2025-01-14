package io.openjob.server.repository.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author inhere
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NotifyGroupDTO extends BaseFieldsDTO {

    /**
     * PK
     */
    private Long id;

    /**
     * Group name
     */
    private String name;

    /**
     * [12, 34]
     */
    private String notifyUserIds;

    /**
     * Status. 1=OK 2=disabled
     */
    private Integer status;

    /**
     * Delete status. 1=yes 2=no
     */
    private Integer deleted;

    /**
     * Delete time
     */
    private Long deleteTime;

    /**
     * Update time
     */
    private Long updateTime;

    /**
     * Create time
     */
    private Long createTime;
}

