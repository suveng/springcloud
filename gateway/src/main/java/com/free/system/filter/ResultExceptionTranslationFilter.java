package com.free.system.filter;

import com.alibaba.fastjson.JSON;
import com.free.system.common.response.ResponseBuilder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * description:
 * @author suwenguang
 * @date 19-7-22
 * @version 1.0.0
 **/
public class ResultExceptionTranslationFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
		try {
			fc.doFilter(request, response);
		} catch (Exception ex) {
			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(JSON.toJSONString(ResponseBuilder.build("5000",ex.getMessage(), new Object())));
			response.getWriter().flush();
		}
	}
}
