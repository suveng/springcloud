package com.free.base;

import com.free.base.enums.RobotEnums;
import com.free.base.robotdingtalk.model.interfaces.InitRobot;
import com.free.base.robotdingtalk.service.impl.TextRobotServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Slf4j
public class Robot {

	/**
	 * 说明: 根据传入的参数获取 robot, 如果发生异常,则默认返回 文字群聊机器人
	 * @return com.free.base.dingtalkrobot.service.InitRobot <- 返回类型
	 */
	public static InitRobot build(RobotEnums robot) {
		Class robotClass = robot.getRobot();
		try {
			Object instance = robotClass.newInstance();
			return (InitRobot) instance;
		} catch (InstantiationException | IllegalAccessException e) {
			log.info("获取initRobot实例失败,创建默认initRobot");
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
		return new TextRobotServiceImpl();
	}

}
