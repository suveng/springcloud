package com.free.system.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/23
 * @version 1.0.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        System.out.println("########服务注册中心启动!########");
        SpringApplication.run(EurekaApplication.class, args);
    }
}
