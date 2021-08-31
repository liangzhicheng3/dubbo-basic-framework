package com.liangzhicheng.modules.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description 登录相关数据传输对象
 * @author liangzhicheng
 * @since 2021-08-30
 */
@Data
public class TestVcodeDTO implements Serializable {

    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "短信验证码")
    private String vcode;

}
