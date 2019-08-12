package com.free.system.user.service;

import com.free.system.user.mapper.UserMapper;
import com.free.system.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-12
 * @version 1.0.0
 **/
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUser() {
		return userMapper.getUser();
	}
}
