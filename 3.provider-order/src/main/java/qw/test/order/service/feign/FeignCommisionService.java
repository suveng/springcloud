package qw.test.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author suwenguang
 **/
@FeignClient(url = "192.168.9.233:19192/ttc",name = "commision-service")
public interface FeignCommisionService {

	@RequestMapping(method = RequestMethod.GET,value = "/health/get")
	Object health();

}
