package com.free.system.order.controller;


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

    /**
     * 说明: 自定义error页面
     * @author  suwenguang
     * @date    2019-07-30
     * @return  java.lang.String <- 返回类型
     */
    @RequestMapping("/error")
    public String error() {
        logger.info("用户访问了 /error");
        return "404";
    }



    @Override
    public String getErrorPath() {
        return "/error";
    }
}
