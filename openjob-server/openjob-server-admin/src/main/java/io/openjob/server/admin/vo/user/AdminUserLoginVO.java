package io.openjob.server.admin.vo.user;

import io.openjob.server.admin.vo.part.MenuItemVO;
import io.openjob.server.admin.vo.part.PermItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@Builder
@ApiModel(value = "AdminUserLoginVO", description = "AdminUserLoginVO")
public class AdminUserLoginVO {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "User name")
    private String username;

    @ApiModelProperty(value = "Nickname")
    private String nickname;

    @ApiModelProperty(value = "Session Key, please set to header \"session: sessionKey\"")
    private String sessionKey;

    @ApiModelProperty(value = "user is supper admin")
    private Boolean supperAdmin;

    @ApiModelProperty(value = "Manage menus for user")
    private List<MenuItemVO> menus;

    @ApiModelProperty(value = "Permissions for user")
    private List<PermItemVO> perms;

}

