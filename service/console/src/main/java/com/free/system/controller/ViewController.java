package com.free.system.controller;

import com.qw.support.currency.result.CodeEnum;
import com.qw.support.currency.result.Result;
import com.qw.support.currency.result.ResultBuilder;
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
	public Result get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String res = localAddr + "-" + localPort;
		return ResultBuilder.build(CodeEnum.SUCCESS,res);
	}

}
