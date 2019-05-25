package com.free.system.user.controller;

import com.alibaba.fastjson.JSON;
import com.free.system.service.common.modules.user.entity.User;
import com.free.system.service.common.response.Response;
import com.free.system.service.common.response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response login(User user){
        log.info("user:{}", JSON.toJSONString(user));
        return ResponseBuilder.buildSimpleSuccessResult();
    }
}
