package com.free.system.order.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;

import com.free.system.common.response.ResponseEnums;
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
	@RequestMapping("/get")
	public Response get(HttpServletRequest request) {
		log.info("用户访问了: "+request.getLocalAddr()+":"+request.getLocalPort());
		return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS, "this is order service");
	}
}
