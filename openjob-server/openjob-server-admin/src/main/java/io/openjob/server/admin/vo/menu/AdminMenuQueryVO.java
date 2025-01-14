package io.openjob.server.admin.vo.menu;

import io.openjob.server.admin.vo.part.MenuMetaVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author inhere
 * @since 1.0.0
 */
@Data
@ApiModel(value = "AdminMenuQueryVO", description = "AdminMenuQueryVO")
public class AdminMenuQueryVO {

    @ApiModelProperty(value = "PK")
    private Long id;

    @ApiModelProperty(value = "Parent ID")
    private Integer pid;

    @ApiModelProperty(value = "Type. 1=menu 2=perm")
    private Integer type;

    @ApiModelProperty(value = "Menu name")
    private String name;

    @ApiModelProperty(value = "Route path or API path")
    private String path;

    @ApiModelProperty(value = "Extra meta data. JSON object: {icon:xx,title:some.name}")
    private MenuMetaVO meta;

    @ApiModelProperty(value = "Hidden status. 1=yes 2=no")
    private Integer hidden;

    @ApiModelProperty(value = "Sort value")
    private Integer sort;

    @ApiModelProperty(value = "Delete status. 1=yes 2=no")
    private Integer deleted;

    @ApiModelProperty(value = "Delete time")
    private Long deleteTime;

    @ApiModelProperty(value = "Update time")
    private Long updateTime;

    @ApiModelProperty(value = "Create time")
    private Long createTime;
}

