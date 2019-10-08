package com.free.system.order.controller;

import com.free.system.order.config.EnvironmentProperties;
import com.free.system.order.model.vo.TestVo;
import com.free.system.order.model.vo.Vo;
import com.qw.support.currency.result.CodeEnum;
import com.qw.support.currency.result.Result;
import com.qw.support.currency.result.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	@Autowired
	EnvironmentProperties environmentProperties;

	/**
	 * 说明: 获取实例基本信息
	 * @author suwenguang
	 * @date 2019-08-08
	 */
	@RequestMapping("/get")
	public Result get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		String res = localAddr + "-" + localPort + "-" + environmentProperties.getVersion();
		return ResultBuilder.build(CodeEnum.SUCCESS, res);
	}

	@RequestMapping("/valid")
	public Result valid(@RequestBody  TestVo testVo) {
		//if (bindingResult.hasErrors()){
		//	List<ObjectError> allErrors = bindingResult.getAllErrors();
		//	Set<String> res = allErrors.stream().map(err -> ((FieldError) err).getField() + ":" + err.getDefaultMessage()).collect(Collectors.toSet());
		//	return ResultBuilder.build(0,"",res);
		//}
		return this.validate(testVo);
	}

	private Result validate(TestVo vo) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Vo>> validate = validator.validate(vo);
		List<String> collect = validate.stream().map(con -> con.getPropertyPath() + ":" + con.getMessage()).collect(Collectors.toList());
		return ResultBuilder.build(CodeEnum.SUCCESS, collect);
	}


}
