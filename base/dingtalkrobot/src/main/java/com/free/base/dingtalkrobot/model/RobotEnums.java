package com.free.base.dingtalkrobot.model;

import com.free.base.dingtalkrobot.service.AbstractInitRobot;
import com.free.base.dingtalkrobot.service.TextRobotServiceImpl;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public enum RobotEnums {
	TEXT_ROBOT(1,"文字群聊机器人", TextRobotServiceImpl.class),
	//LINK_ROBOT(2,"链接群聊机器人"),
	;

	private Integer code;
	private String name;
	private  Class<? extends AbstractInitRobot> robot;


	RobotEnums(Integer code, String name, Class<? extends AbstractInitRobot> robot) {
		this.code = code;
		this.name = name;
		this.robot = robot;
	}

	public Class getRobot() {
		return robot;
	}

	public void setRobot(Class<? extends AbstractInitRobot> robot) {
		this.robot = robot;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}}
