package io.openjob.server.admin.vo.notify;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author inhere
 * @date 2022-11-15 14:19:59
 * @since 1.0.0
 */
@Data
@ApiModel(value = "NotifyGroupVO", description = "NotifyGroup add VO")
public class NotifyGroupAddVO {

    @ApiModelProperty(value = "PK")
    private Long id;
}

