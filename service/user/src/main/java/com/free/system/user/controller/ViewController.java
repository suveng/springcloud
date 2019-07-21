package com.free.system.user.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/17
 * @version 1.0.0
 **/
@Controller
public class ViewController implements ErrorController {
    /** Field logger  */
    private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
    @RequestMapping("/error")
    public String error() {
        logger.info("用户访问了 /error");
        return "404";
    }


    /**
     * 方法:  index
     * @author suwenguang
     * @date 2019/5/20
     * @return String
     */
    @RequestMapping("/index.html")
    public String index() {
        logger.info("用户访问了 /index");
        return "index";
    }


    /**
     * 方法:  login:返回登录页面
     * @author suwenguang
     * @date 2019/5/22
     * @return String
     */
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
