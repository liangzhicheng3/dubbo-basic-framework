package com.liangzhicheng.modules.controller.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.basic.ResponseResult;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.TestUserDTO;
import com.liangzhicheng.modules.entity.vo.TestUserVO;
import com.liangzhicheng.modules.service.ITestAreaNameService;
import com.liangzhicheng.modules.service.ITestUserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 【客户端】用户控制器
 * @author liangzhicheng
 * @since 2021-08-27
 */
@Api(value = "UserClientController", tags = {"【客户端】用户相关控制器"})
@RestController
@RequestMapping("/client/user")
public class UserClientController extends BaseController {

    @Reference
    private ITestUserService userService;

    @ApiOperation(value = "保存用户")
    @PostMapping("/saveUser")
    @ApiOperationSupport(ignoreParameters = {"userDTO.id"})
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "success", response = TestUserVO.class)})
    @LoginValidate
    public ResponseResult saveUser(@RequestBody TestUserDTO userDTO){
        return buildSuccessInfo(userService.saveUser(userDTO));
    }

    @ApiOperation(value = "获取用户")
    @PostMapping("/getUser")
    @ApiOperationSupport(ignoreParameters = {
            "userDTO.username", "userDTO.phone"})
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "success", response = TestUserVO.class)})
    public ResponseResult getUser(@RequestBody TestUserDTO userDTO){
        return buildSuccessInfo(userService.getUser(userDTO));
    }

}
