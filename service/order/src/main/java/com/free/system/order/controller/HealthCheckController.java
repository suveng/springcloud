package com.free.system.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * health check
 * @author suwenguang
 * @version 1.0.0
 **/
@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public String healthCheck() {
		return "health";
	}

}

