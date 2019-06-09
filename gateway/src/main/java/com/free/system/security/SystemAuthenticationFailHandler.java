package com.free.system.security;

import com.alibaba.fastjson.JSON;
import com.free.system.response.IResponse;
import com.free.system.response.Response;
import com.free.system.response.ResponseBuilder;
import com.free.system.response.ResponseEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description:认证失败的处理器
 * @author suwenguang
 * @date 2019/6/8
 * @version 1.0.0
 **/
@Component
@Slf4j
public class SystemAuthenticationFailHandler implements AuthenticationFailureHandler {
    /**
     * 说明: 认证失败后,执行的方法
     * @author suwenguang
     * @date 2019/6/8
     * @return void <- 返回类型
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败:{}", exception.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        IResponse res = ResponseBuilder.build(ResponseEnums.LOGIN_FAIL, exception.getMessage());
        writer.write(JSON.toJSONString(res));
    }
}
