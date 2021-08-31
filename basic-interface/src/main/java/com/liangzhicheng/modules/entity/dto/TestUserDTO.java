package com.liangzhicheng.modules.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 用户相关数据传输对象
 * @author liangzhicheng
 * @since 2021-08-28
 */
@Data
public class TestUserDTO implements Serializable {

    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("手机号码")
    private String phone;

}
