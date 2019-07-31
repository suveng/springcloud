package com.free.system;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/23
 * @version 1.0.0
 **/
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
@EnableEurekaClient
public class AdminServerApplication {

	public static void main(String[] args) {
		System.out.println("########监控中心启动!########");
		SpringApplication.run(AdminServerApplication.class, args);
	}
}
