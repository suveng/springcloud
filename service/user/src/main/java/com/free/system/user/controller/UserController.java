package com.free.system.user.controller;

import com.free.system.common.response.Response;
import com.free.system.common.response.ResponseBuilder;
import com.free.system.common.response.ResponseEnums;
import com.free.system.third.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-30
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/getUserInfo")
	public Response getUserInfo(){
		Response response = orderService.get();
		return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS,response);
	}
}
