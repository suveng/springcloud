package com.qw.support.currency.message;


import com.qw.support.currency.message.enums.RobotEnums;
import com.qw.support.currency.message.robotdingtalk.model.interfaces.InitRobot;
import com.qw.support.currency.message.robotdingtalk.service.impl.TextRobotServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class Robot {

	private static final Logger logger = LoggerFactory.getLogger(Robot.class);

	/**
	 * 说明: 根据传入的参数获取 robot, 如果发生异常,则默认返回 文字群聊机器人
	 */
	public static InitRobot build(RobotEnums robot) {
		Class robotClass = robot.getRobot();
		try {
			Object instance = robotClass.newInstance();
			return (InitRobot) instance;
		} catch (InstantiationException | IllegalAccessException e) {
			logger.info("获取initRobot实例失败,创建默认initRobot");
			if (logger.isDebugEnabled()) {
				e.printStackTrace();
			}
		}
		return new TextRobotServiceImpl();
	}

}
