package io.openjob.server.admin.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "UpdateAdminUserRequest", description = "Update Admin User Request")
public class AdminUserUpdateRequest {

    @Min(1)
    @NotNull
    @ApiModelProperty(value = "PK")
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "User name")
    private String username;

    @NotNull
    @ApiModelProperty(value = "Nickname")
    private String nickname;

    @ApiModelProperty(value = "Password, md5 hashed before submit")
    private String passwd;

    @ApiModelProperty(value = "Api auth token")
    private String token;

    @NotNull
    @Size(min = 1)
    @ApiModelProperty(value = "Role IDs. JSON: [1,2]")
    private List<Long> roleIds;

    @ApiModelProperty(value = "Delete status. 1=yes 2=no")
    private Integer deleted;
}

