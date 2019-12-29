package qw.test.order.service.feign.circuit;

import org.springframework.stereotype.Component;
import qw.test.order.service.feign.FeignCommisionService;

/**
 * 断路器
 * @author suwenguang
 **/
@Component
public class CommisionServiceFallback implements FeignCommisionService {
	@Override
	public Object health() {
		return "xx服务不健康,断路器,默认返回";
	}
}
