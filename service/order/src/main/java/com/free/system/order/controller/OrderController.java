package com.free.system.order.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;

import com.free.system.common.response.ResponseEnums;
import com.free.system.common.response.ResponseEnumsDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-30
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
	@Value("${env}")
	private String env;

	@Value("${version}")
	private String version;

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


}
