package qw.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qw.test.order.service.feign.FeignUserService;

/**
 *
 * @author suwenguang
 **/
@RestController
public class FeignController {

	@Qualifier("test-user-provider-service")
	@Autowired
	private FeignUserService feignUserService;

	@RequestMapping("/getUser")
	public String userGet(){
		return feignUserService.get();
	}
}
