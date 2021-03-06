package com.liangzhicheng.modules.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 地区名称VO类
 * @author liangzhicheng
 * @since 2021-08-30
 */
@Data
@ApiModel(value="TestAreaNameVO")
public class TestAreaNameVO implements Serializable {

    @ApiModelProperty("地区id")
    private String areaId;
    @ApiModelProperty("地区编码")
    private String areaCode;
    @ApiModelProperty("地区名称")
    private String areaName;
    @ApiModelProperty("地区层级")
    private Integer areaLevel;

}
