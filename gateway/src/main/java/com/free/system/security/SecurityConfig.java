package com.free.system.security;

import com.free.system.filter.ResultExceptionTranslationFilter;
import com.free.system.filter.TokenAuthenticationFilter;
import com.free.system.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/7
 * @version 1.0.0
 **/
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ITokenService tokenService;


	/**
	 * 添加自定义provider授权器
	 * @param auth
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new TokenAuthenticationProvider(this.tokenService));
	}

	/**
	 * 说明: 重写security的配置方法
	 * @author suwenguang
	 * @date 2019/6/7
	 * @return void <- 返回类型
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//配置
		http
			.antMatcher("/api/**")//捕获到url
			.addFilterAfter(new TokenAuthenticationFilter(), BasicAuthenticationFilter.class)//在BasicAuthenticationFilter之后增加过滤器
			.addFilterAfter(new ResultExceptionTranslationFilter(), ExceptionTranslationFilter.class)//在ExceptionTranslationFilter之后添加过滤器
			.authorizeRequests()//授权
			.anyRequest().hasRole("API")//只有拥有api权限才通过
			.and()
			.csrf()
			.disable();
	}
}
