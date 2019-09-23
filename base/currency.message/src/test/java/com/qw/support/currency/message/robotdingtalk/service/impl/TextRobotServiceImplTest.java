package com.qw.support.currency.message.robotdingtalk.service.impl;

import com.qw.support.currency.message.Robot;
import com.qw.support.currency.message.enums.RobotEnums;
import com.qw.support.currency.message.robotdingtalk.service.IRobotService;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class TextRobotServiceImplTest {

	@Test
	public void init() {
	}

	@Test
	public void sendMsgAsync() throws InterruptedException, ExecutionException, TimeoutException {
		IRobotService init = Robot.build(RobotEnums.TEXT_ROBOT).init("https://oapi.dingtalk.com/robot/send?access_token=5539bb85df332e12ba0b3b782e0a934d9c654252266010cd4a1c8515bda947f6");
		init.sendMsgAsync("hello");
		Thread.sleep(3*1000);
	}

	@Test
	public void sendMsgAtAsync() {
	}

	@Test
	public void sendMsg() {
	}

	@Test
	public void sendMsgAt() {
	}

	@Test
	public void testSendMsgAt() {
	}

	@Test
	public void sendMsgAtAll() {
	}

	@Test
	public void sendMsgType() {
	}

	@Test
	public void testSendMsgType() {
	}
}
