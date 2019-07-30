package com.free.system.order.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;

import com.free.system.common.response.ResponseEnums;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-30
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
	@RequestMapping("/get")
	public Response get() {
		return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS, "this is order service");
	}
}
