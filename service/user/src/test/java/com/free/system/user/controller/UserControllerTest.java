package com.free.system.user.controller;

import com.free.system.UserBaseTest;
import com.free.system.common.response.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-12
 * @version 1.0.0
 **/
public class UserControllerTest extends UserBaseTest {

	@Autowired
	private UserController userController;

	@Test
	public void getUser() {
		Response user = userController.getUser();
		System.out.println(user);
	}
}
