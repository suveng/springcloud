package com.free.system.user.controller;

import com.free.system.service.common.response.Response;
import com.free.system.service.common.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/24
 * @version 1.0.0
 **/
@RestController
@Slf4j
public class UserController {

    @RequestMapping("/login")
    public Response login(HttpServletRequest httpServletRequest){
        log.info("访问路径:{}",httpServletRequest.getRequestURI());
        return ResponseBuilder.buildSimpleSuccessResult();
    }
}
