package io.openjob.server.admin.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "AdminRuleListRequest", description = "AdminRule page list request")
public class AdminRuleListRequest {

    @ApiModelProperty(value = "List page.")
    private Integer page = 1;

    @ApiModelProperty(value = "List size. default 10")
    private Integer size = 10;

}

