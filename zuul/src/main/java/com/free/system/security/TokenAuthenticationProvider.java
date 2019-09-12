package com.free.system.security;

import com.free.system.service.ITokenService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 * description:
 * @author suwenguang
 * @date 19-7-22
 * @version 1.0.0
 **/
public class TokenAuthenticationProvider implements AuthenticationProvider {
	private final ITokenService tokenService;

	@Autowired
	public TokenAuthenticationProvider(ITokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		if (authentication.isAuthenticated()) {
			return authentication;
		}

		// 从 TokenAuthentication 中获取 token
		String token = authentication.getCredentials().toString();
		if (Strings.isNullOrEmpty(token)) {
			return authentication;
		}

		UserDetails user = tokenService.authenticateToken(token);

		// 返回新的认证信息，带上 token 和反查出的用户信息
		Authentication auth = new PreAuthenticatedAuthenticationToken(user, token, user.getAuthorities());
		auth.setAuthenticated(true);
		return auth;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return (TokenAuthentication.class.isAssignableFrom(aClass));
	}
}
