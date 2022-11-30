package io.openjob.server.admin.request.notify;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "NotifyTemplateQueryRequest", description = "NotifyTemplate query request")
public class NotifyTemplateQueryRequest {

    @Min(1)
    @NotNull()
    @ApiModelProperty(value = "PK")
    private Long id;

}

