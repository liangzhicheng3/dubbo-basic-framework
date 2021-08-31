package com.liangzhicheng.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liangzhicheng.common.exception.TransactionException;
import com.liangzhicheng.modules.entity.TestUserEntity;
import com.liangzhicheng.modules.entity.dto.TestLoginPhoneDTO;
import com.liangzhicheng.modules.entity.dto.TestLoginWeChatDTO;
import com.liangzhicheng.modules.entity.dto.TestUserDTO;
import com.liangzhicheng.modules.entity.dto.TestVcodeDTO;
import com.liangzhicheng.modules.entity.vo.TestUserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 用户服务接口类
 * @author liangzhicheng
 * @since 2021-08-27
 */
public interface ITestUserService extends IService<TestUserEntity> {

    /**
     * @description 获取短信验证码
     * @param userLoginDTO
     */
    void sendSMS(TestVcodeDTO userLoginDTO);

    /**
     * @description APP手机号码登录
     * @param loginDTO
     * @return TestUserVO
     */
    TestUserVO loginPhone(TestLoginPhoneDTO loginDTO);

    /**
     * @description APP授权登录
     * @param loginDTO
     * @return TestUserVO
     */
    TestUserVO loginCodeAPP(TestLoginWeChatDTO loginDTO);

    /**
     * @description 小程序授权登录
     * @param loginDTO
     * @return TestUserVO
     */
    TestUserVO loginMINI(TestLoginWeChatDTO loginDTO);

    /**
     * @description APP退出登录
     * @param request
     */
    void logOutAPP(HttpServletRequest request);

    /**
     * @description 保存用户
     * @param userDTO
     * @return TestUserVO
     */
    TestUserVO saveUser(TestUserDTO userDTO) throws TransactionException;

    /**
     * @description 获取用户
     * @param userDTO
     * @return TestUserVO
     */
    TestUserVO getUser(TestUserDTO userDTO);

}
