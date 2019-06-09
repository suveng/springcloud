package com.free.system.controller;

import com.free.system.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/8
 * @version 1.0.0
 **/
@RestController
@Slf4j
public class UserController {
    /**
     * 说明: REST 接口返回错误码,需要登录,让客户端处理
     * @author  suwenguang
     * @date    2019/6/8
     * @return  com.free.system.response.Response <- 返回类型
     */
    @RequestMapping("/login.html")
    public IResponse loginView(){
        return ResponseBuilder.build(OtherResponseDemo.class,ResponseEnums.NEED_LOGIN,null);
    }

}
