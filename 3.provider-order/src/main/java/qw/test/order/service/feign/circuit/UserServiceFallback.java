package qw.test.order.service.feign.circuit;

import org.springframework.stereotype.Component;
import qw.test.order.service.feign.FeignUserService;

/**
 * 服务断路器
 * @author suwenguang
 **/
@Component
public class UserServiceFallback implements FeignUserService {
	/**
	 * 断路器支持
	 */
	@Override
	public String get() {
		return "fallback";
	}
}
