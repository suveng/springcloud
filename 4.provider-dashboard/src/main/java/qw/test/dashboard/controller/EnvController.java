package qw.test.dashboard.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@RestController
@RefreshScope
public class EnvController {

	@Value("${env.version}")
	private String version;

	@Value("${env.author}")
	private String author;

	@Value("${spring.profiles.active}")
	private String profiles;

	@Value("${test}")
	private String test;

	@RequestMapping("/get")
	public String get(){
		return version + ":" + author;
	}

	@RequestMapping("/get/profiles")
	public String getProfiles(){
		return profiles+test;
	}


}
