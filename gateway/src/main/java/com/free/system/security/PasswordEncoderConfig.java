package com.free.system.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * description: 注入明文密码加密解密工具
 * @author suwenguang
 * @date 2019/6/7
 * @version 1.0.0
 **/
@Configuration
public class PasswordEncoderConfig {
    /**
     * 说明: 注入一个明文密码的加解密
     * @author suwenguang
     * @date 2019/6/7
     * @return org.springframework.security.crypto.password.PasswordEncoder <- 返回类型
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
