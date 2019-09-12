package com.free.system.filter;

import com.free.system.security.TokenAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * description:过滤器会读取 URL 中的 parameter 并生成定义的 TokenAuthentication
 * @author suwenguang
 * @date 19-7-22
 * @version 1.0.0
 **/
public class TokenAuthenticationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain fc) throws ServletException, IOException {
		SecurityContext context = SecurityContextHolder.getContext();
		//已认证
		if (context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
			// do nothing
		} else {
			// ②
			Map<String, String[]> params = req.getParameterMap();
			if (!params.isEmpty() && params.containsKey("token")) {
				String token = params.get("token")[0];
				if (token != null) {
					Authentication auth = new TokenAuthentication(token);
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
			req.setAttribute("me.lotabout.springsecurityexample.security.TokenAuthenticationFilter.FILTERED", true); //③
		}

		fc.doFilter(req, res); //④
	}
}
