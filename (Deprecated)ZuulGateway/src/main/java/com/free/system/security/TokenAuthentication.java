package com.free.system.security;

import com.google.common.base.Strings;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class TokenAuthentication implements Authentication {

	/**
	 * 存放token的信息
	 **/
	private String token;

	public TokenAuthentication(String token) {
		if (Strings.isNullOrEmpty(token)) {
			this.token = "guest";
		}
		this.token = token;
	}

	public TokenAuthentication() {
		this.token = "guest";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Object getCredentials() {
		return this.token;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return false;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

	}

	@Override
	public String getName() {
		return null;
	}
}
