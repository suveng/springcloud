package qw.test.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qw.test.order.service.feign.circuit.CommisionServiceFallback;

/**
 *
 * @author suwenguang
 **/
@FeignClient(name = "commision-service", url = "192.168.9.233:19192/ttc", fallback = CommisionServiceFallback.class)
public interface FeignCommisionService {

	@RequestMapping(method = RequestMethod.GET,value = "/health/get")
	Object health();

}
