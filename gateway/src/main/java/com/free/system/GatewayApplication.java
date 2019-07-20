package com.free.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/23
 * @version 1.0.0
 **/
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {
	public static void main(String[] args) {
		System.out.println("########服务网关启动!########");
		SpringApplication.run(GatewayApplication.class, args);
	}
}
