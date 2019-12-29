package qw.test.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign声明
 * @author suwenguang
 **/
@FeignClient(value = "test-user-provider-service")
public interface FeignUserService {

	@RequestMapping("/user/get")
	String get();
}
