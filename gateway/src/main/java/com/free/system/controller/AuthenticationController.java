package com.free.system.controller;

import cn.hutool.core.lang.Assert;
import com.free.system.model.UserVo;
import com.free.system.common.response.*;
import com.free.system.security.UserCertificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/8
 * @version 1.0.0
 **/
@RestController
@Slf4j
public class AuthenticationController {
	@Autowired
	private UserCertificationService userCertificationService;

	/**
	 * 说明: REST 接口返回错误码,需要登录,让客户端处理
	 * @author suwenguang
	 * @date 2019/6/8
	 * @return com.free.system.common.response.Response <- 返回类型
	 */
	@RequestMapping("/login.html")
	public IResponse loginView() {
		return ResponseBuilder.build(OtherResponseDemo.class,ResponseEnums.NEED_LOGIN, new Object());
	}

	@RequestMapping("/login")
	public IResponse login(UserVo userVo) {
		Assert.notNull(userVo);
		Assert.notBlank(userVo.getUsername());
		UserDetails userDetails = userCertificationService.loadUserByUsername(userVo.getUsername());
		return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS, userDetails);
	}

}
