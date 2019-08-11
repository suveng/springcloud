package com.free.base.dingtalkrobot.service;

import com.free.base.dingtalkrobot.model.DingTalkResult;
import com.free.base.dingtalkrobot.model.ServiceResult;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-11
 * @version 1.0.0
 **/
public interface IRobotService  {



	/**
	 * 说明: 发送消息,默认文本类型
	 * @author  suwenguang
	 * @date    2019-08-11
	 * @return  com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult>  sendMsg(String content);


	/**
	 * 说明: 发送不同类型的内容
	 * @author  suwenguang
	 * @date    2019-08-11
	 * @return  com.free.base.dingtalkrobot.model.ServiceResult<com.free.base.dingtalkrobot.model.DingTalkResult> <- 返回类型
	 */
	ServiceResult<DingTalkResult> sendMsg(String msgtype, String content);


	ServiceResult<DingTalkResult> sendMsg(String msgtype, String content, List<String> atMobiles, Boolean isAtALl);
}
