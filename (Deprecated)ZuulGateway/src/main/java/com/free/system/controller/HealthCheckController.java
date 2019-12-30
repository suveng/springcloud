package com.free.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

	@GetMapping("/health/get")
	public String get(HttpServletRequest request) {
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		return localAddr+localPort;
	}

}

