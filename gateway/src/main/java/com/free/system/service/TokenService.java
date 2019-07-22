package com.free.system.service;

import com.free.system.service.ITokenService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * description:
 * @author suwenguang
 * @date 19-7-22
 * @version 1.0.0
 **/
@Service
public class TokenService implements ITokenService {
	@Override
	public UserDetails authenticateToken(String token) {
		if (token.equals("abcdefg")) {
			return User.builder()
				.username("api")
				.password("")
				.authorities("ROLE_API")
				.accountExpired(true)
				.accountLocked(true)
				.credentialsExpired(true)
				.disabled(true)
				.build();
		}
		throw new IllegalArgumentException();
	}
}
