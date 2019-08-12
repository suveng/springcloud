package com.free.system.user.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;
import com.free.system.common.response.ResponseEnums;
import com.free.system.common.response.ResponseEnumsDemo;
import com.free.system.third.order.OrderService;
import com.free.system.user.model.User;
import com.free.system.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-30
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Value("${env}")
	private String env;

	@Value("${version}")
	private String version;

	@Autowired
	private OrderService orderService;

	@Autowired
	private IUserService userService;

	/**
	 * 说明: 获取实例基本信息
	 * @author suwenguang
	 * @date 2019-08-08
	 * @return com.free.system.common.response.Response <- 返回类型
	 */
	@RequestMapping("/get")
	public Response get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String res = localAddr + "-" + localPort + "-" + this.env + "-" + this.version;
		return ResponseBuilder.build(ResponseEnumsDemo.SIMPLE_SUCCESS, res);
	}


	@RequestMapping("/getUserInfo")
	public Response getUserInfo() {
		Response response = orderService.get();
		return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS, response);
	}

	/**
	 * 说明: 测试 config 改变数据库信息
	 * @author  suwenguang
	 * @date    2019-08-12
	 * @return  com.free.system.common.response.Response <- 返回类型
	 */
	@RequestMapping("/getUser")
	public Response getUser() {
		List<User> res = new ArrayList<>();
		try {
			res = userService.getUser();
		} catch (Exception e) {
			log.error("系统异常",e);
		}
		return ResponseBuilder.build(ResponseEnumsDemo.SIMPLE_SUCCESS, res);
	}
}
