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
		IRobotService init = Robot.build(RobotEnums.TEXT_ROBOT).init("https://oapi.dingtalk.com/robot/send?access_token=98e610ee1f6aa45e508641e525c2d02322cc4e061b3c670da50da00d64b79e01");
		ServiceResult<DingTalkResult> text = init.sendMsg("text", "策略模式+工厂模式", null, false);
		System.out.println(JSON.toJSONString(text));
	}
}
