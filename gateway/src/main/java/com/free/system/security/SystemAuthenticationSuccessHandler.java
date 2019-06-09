package com.free.system.security;

import com.alibaba.fastjson.JSON;
import com.free.system.response.Response;
import com.free.system.response.ResponseBuilder;
import com.free.system.response.ResponseEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description: 自定义登录成功处理器
 * @author suwenguang
 * @date 2019/6/8
 * @version 1.0.0
 **/
@Component
@Slf4j
public class SystemAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 说明:登录成功后,执行的方法
     * @author suwenguang
     * @date 2019/6/8
     * @return void <- 返回类型
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功:{}", JSON.toJSONString(authentication));
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Response res = ResponseBuilder.build(ResponseEnums.SIMPLE_SUCCESS, authentication);
        writer.write(JSON.toJSONString(res));
    }
}
