package io.openjob.server.admin.vo.notify;

import io.openjob.server.admin.vo.part.TemplateExtraVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "NotifyTemplateQueryVO", description = "NotifyTemplate query VO")
public class NotifyTemplateQueryVO {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "Template name. eg: Wechat, DingTalk, Wecom, Feishu")
    private String name;

    @ApiModelProperty(value = "notify type. 1 webhook 2 email 3 sms")
    private Integer type;

    @ApiModelProperty(value = "Level. 1 notice 2 warning 3 error")
    private String level;

    @ApiModelProperty(value = "notify events list. JSON: [task_fail, task_suc, task_cancel, task_skip]")
    private List<String> events;

    @ApiModelProperty(value = "related contact ids. JSON [12, 34]")
    private List<Long> contactIds;

    @ApiModelProperty(value = "related group ids. JSON [12, 34]")
    private List<Long> groupIds;

    @ApiModelProperty(value = "Webhook URL")
    private String webhook;

    @ApiModelProperty(value = "Template contents")
    private String content;

    @ApiModelProperty(value = "Extra info. eg: third platform token")
    private TemplateExtraVO extra;

    @ApiModelProperty(value = "Creator user ID")
    private Integer userId;

    @ApiModelProperty(value = "Delete status. 1=yes 2=no")
    private Integer deleted;

    @ApiModelProperty(value = "Delete time")
    private Long deleteTime;

    @ApiModelProperty(value = "Update time")
    private Long updateTime;

    @ApiModelProperty(value = "Create time")
    private Long createTime;
}

