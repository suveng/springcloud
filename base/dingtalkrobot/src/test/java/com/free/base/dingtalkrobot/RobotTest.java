package com.free.base.dingtalkrobot;

import com.alibaba.fastjson.JSON;
import com.free.base.dingtalkrobot.model.DingTalkResult;
import com.free.base.dingtalkrobot.model.RobotEnums;
import com.free.base.dingtalkrobot.model.ServiceResult;
import com.free.base.dingtalkrobot.service.IRobotService;
import org.junit.Test;

import static org.junit.Assert.*;

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
