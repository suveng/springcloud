package com.free.system.security;

import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private SystemAuthenticationSuccessHandler systemAuthenticationSuccessHandler;
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
                //自定义登录方法--REST 不需要
                .loginProcessingUrl("")
                .loginPage("/login")
                //自定义登录认证成功处理器
                .successHandler(systemAuthenticationSuccessHandler)
                .and()
                .authorizeRequests()
                //配置不需要认证的路由
                //.antMatchers("**login","**static").permitAll()
                //所有路由都要认证
                .anyRequest().authenticated()
                //禁用跨站攻击防护机制
                .and().csrf().disable()
                ;
    }
}
