package io.openjob.server.admin.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-15 14:16:56
 * @since 1.0.0
 */
@Data
@ApiModel(value = "AdminRuleUpdateVO", description = "AdminRule update VO")
public class AdminRuleUpdateVO {

    @ApiModelProperty(value = "PK")
    private Long id;

}
