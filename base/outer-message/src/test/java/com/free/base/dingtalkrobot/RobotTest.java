package com.free.base.dingtalkrobot;

import com.alibaba.fastjson.JSON;
import com.free.base.Robot;
import com.free.base.robotdingtalk.model.bo.DingTalkResult;
import com.free.base.enums.RobotEnums;
import com.free.base.model.ServiceResult;
import org.junit.Test;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class RobotTest {

	@Test
	public void build() {
		ServiceResult<DingTalkResult> text = Robot.build(RobotEnums.TEXT_ROBOT)
													.init("https://oapi.dingtalk.com/robot/send?access_token=xx")
													.sendMsg("策略模式+工厂模式");
		System.out.println(JSON.toJSONString(text));
	}
}
