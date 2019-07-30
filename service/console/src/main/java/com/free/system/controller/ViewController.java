package com.free.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * @author suwenguang
 * @date 2019-07-27
 * @version 1.0.0
 **/
@Controller
@RequestMapping("/console")
public class ViewController {

	@RequestMapping("/index.html")
	public String indexHtml() {
		return "index";
	}

	@RequestMapping("/welcome.html")
	public String welcomeHtml(){
		return "welcome";
	}

}
