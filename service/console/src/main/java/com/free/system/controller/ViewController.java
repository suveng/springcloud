package com.free.system.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;
import com.free.system.common.response.ResponseEnumsDemo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-27
 * @version 1.0.0
 **/
@Controller
@RequestMapping("/console")
public class ViewController {
	@Value("${env}")
	private String env;

	@Value("${version}")
	private String version;

	@RequestMapping("/index.html")
	public String indexHtml() {
		return "index";
	}

	@RequestMapping("/welcome.html")
	public String welcomeHtml() {
		return "welcome";
	}



	/**
	 * 说明: 获取实例基本信息
	 * @author suwenguang
	 * @date 2019-08-08
	 * @return com.free.system.common.response.Response <- 返回类型
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Response get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String res = localAddr + "-" + localPort + "-" + this.env + "-" + this.version;
		return ResponseBuilder.build(ResponseEnumsDemo.SIMPLE_SUCCESS, res);
	}

}
