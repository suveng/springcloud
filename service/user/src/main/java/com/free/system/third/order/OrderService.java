package com.free.system.third.order;

import com.free.system.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-30
 * @version 1.0.0
 **/
@FeignClient(name = "ORDER-SERVICE",path = "/order")
public interface OrderService {
	@GetMapping("/get")
	Response get();
}
