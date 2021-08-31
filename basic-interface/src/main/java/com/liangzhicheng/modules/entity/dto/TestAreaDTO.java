package com.liangzhicheng.modules.entity.dto;

import com.liangzhicheng.modules.entity.dto.basic.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 地区相关数据传输对象
 * @author liangzhicheng
 * @since 2021-08-30
 */
@Data
public class TestAreaDTO extends BaseDTO implements Serializable {

    /**
     * areaLevel为0时可以为空
     */
    @ApiModelProperty(value = "地区id")
    private String areaId;
    @ApiModelProperty(value = "地区层级", required = true)
    private String areaLevel;

    /**
     * 查询参数
     */
    @ApiModelProperty(value = "国家")
    private String country;
    @ApiModelProperty(value = "省份")
    private String province;
    @ApiModelProperty(value = "城市")
    private String city;

}
