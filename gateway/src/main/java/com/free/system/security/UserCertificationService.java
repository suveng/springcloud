package com.free.system.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/6/7
 * @version 1.0.0
 **/
@Component
@Slf4j
public class UserCertificationService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名:{}", username);
        log.info("密码:{}",passwordEncoder.encode("123456"));
        //根据username到数据库获取用户信息
        return new User(username, passwordEncoder.encode("123456")
                ,true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }
}
