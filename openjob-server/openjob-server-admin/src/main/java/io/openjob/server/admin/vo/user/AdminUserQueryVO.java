package io.openjob.server.admin.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "AdminUserQueryVO", description = "AdminUserQueryVO")
public class AdminUserQueryVO {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "User name")
    private String username;

    @ApiModelProperty(value = "Nickname")
    private String nickname;

    @ApiModelProperty(value = "Api auth token")
    private String token;

    @ApiModelProperty(value = "Role IDs. JSON: [1,2]")
    private List<Long> roleIds;

    @ApiModelProperty(value = "Delete status. 1=yes 2=no")
    private Integer deleted;

    @ApiModelProperty(value = "Delete time")
    private Long deleteTime;

    @ApiModelProperty(value = "Update time")
    private Long updateTime;

    @ApiModelProperty(value = "Create time")
    private Long createTime;
}

