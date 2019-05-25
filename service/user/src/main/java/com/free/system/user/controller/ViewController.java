package com.free.system.user.controller;


import com.free.system.service.common.costtime.usage.CostTime;
import com.free.system.service.common.logback.LogbackFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/17
 * @version 1.0.0
 **/
@Controller
public class ViewController {
    /** Field logger  */
    private Logger logger = LogbackFactory.SYSTEM_LOGGER;


    /**
     * 方法:  index
     * @author suwenguang
     * @date 2019/5/20
     * @return String
     */
    @RequestMapping("/index.html")
    @CostTime
    public String index() {
        logger.info("用户访问了 /index");
        return "index";
    }

    /**
     * 方法:  welcom
     * @author suwenguang
     * @date 2019/5/20
     * @return String
     */
    @RequestMapping("/welcome.html")
    @CostTime
    public String welcome() {
        logger.info("用户访问了 /welcome");
        return "welcome";
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
}
