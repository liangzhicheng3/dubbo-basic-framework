package com.liangzhicheng.modules.controller.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.basic.ResponseResult;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.modules.entity.dto.TestAreaDTO;
import com.liangzhicheng.modules.entity.vo.TestAreaNameVO;
import com.liangzhicheng.modules.service.ITestAreaNameService;
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
@Api(value = "AreaClientController", tags = {"【客户端】地区相关控制器"})
@RestController
@RequestMapping("/client/area")
public class AreaClientController extends BaseController {

    @Reference
    private ITestAreaNameService areaNameService;

    @ApiOperation(value = "地区列表")
    @PostMapping(value = "/listArea")
    @ApiOperationSupport(ignoreParameters = {"areaDTO.country",
            "areaDTO.province", "areaDTO.city"})
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = TestAreaNameVO.class)})
    public ResponseResult listArea(@RequestBody TestAreaDTO areaDTO){
        return buildSuccessInfo(areaNameService.listArea(areaDTO));
    }

}
