package com.free.system.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * description:
 * @author suwenguang
 * @date 19-7-22
 * @version 1.0.0
 **/
public interface ITokenService {

	UserDetails authenticateToken(String token);

}
