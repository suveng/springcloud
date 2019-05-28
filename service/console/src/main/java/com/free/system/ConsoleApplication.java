package com.free.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/28
 * @version 1.0.0
 **/
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
@MapperScan("com.free.system.service.common.modules.*.mapper")
public class ConsoleApplication {
    public static void main(String[] args) {
        System.out.println("####控制台服务####");
        SpringApplication.run(ConsoleApplication.class, args);
    }
}
