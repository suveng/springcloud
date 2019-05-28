package com.free.system.user.controller;

import com.alibaba.fastjson.JSON;
import com.free.system.service.common.modules.user.model.User;
import com.free.system.service.common.modules.user.service.UserService;
import com.free.system.service.common.response.Response;
import com.free.system.service.common.response.ResponseBuilder;
import com.free.system.service.common.response.ResponseEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/24
 * @version 1.0.0
 **/
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Response login(User user, HttpServletRequest  request, HttpServletResponse response){
        log.info("user:{}", JSON.toJSONString(user));
        //校验参数
        if (ObjectUtils.isEmpty(user)){
            log.error("user参数不能为空");
            return ResponseBuilder.buildSimpleIllegalArgumentError();
        }
        //用户登录比对逻辑:todo
        User user1 = userService.selectByPrimaryKey(1);
        //设置cookie
        Cookie cookie = new Cookie("token", "123");
        response.addCookie(cookie);
        //设置session
        request.getSession().setAttribute("token", "123");
        //设置返回体
        user.setToken("123");
        return ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS,user);
    }
}
