package com.free.system.controller;

import com.free.system.config.EnvironmentProperties;
import com.qw.support.currency.result.CodeEnum;
import com.qw.support.currency.result.Result;
import com.qw.support.currency.result.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * app
 * @author suwenguang
 * @version 1.0.0
 **/
@RestController
@RequestMapping("/zuul")
public class AppController {

	@Autowired
	private EnvironmentProperties environmentProperties;

	@RequestMapping("/get")
	public Result get(){
		return ResultBuilder.build(CodeEnum.SUCCESS,environmentProperties);
	}
}
