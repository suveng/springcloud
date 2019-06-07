package com.free.system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/6/7
 * @version 1.0.0
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    /**
     * 说明: 重写security的配置方法
     * @author suwenguang
     * @date 2019/6/7
     * @return void <- 返回类型
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置
        http.formLogin()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
