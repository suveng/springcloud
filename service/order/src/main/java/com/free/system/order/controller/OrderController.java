package com.free.system.order.controller;

import com.qw.support.currency.result.CodeEnum;
import com.qw.support.currency.result.Result;
import com.qw.support.currency.result.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
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

	/**
	 * 说明: 获取实例基本信息
	 * @author suwenguang
	 * @date 2019-08-08
	 */
	@RequestMapping("/get")
	public Result get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String res = localAddr + "-" + localPort;
		return ResultBuilder.build(CodeEnum.SUCCESS, res);
	}


}
