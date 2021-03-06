package com.qw.support.currency.message.robotdingtalk.service;


import com.qw.support.currency.message.robotdingtalk.model.bo.DingTalkResult;
import com.qw.support.currency.result.ServiceResult;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public interface IRobotService {


	/**
	 * 说明: 发送消息,默认文本类型
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsg(String content);

	/**
	 * 说明: 异步发送消息,默认文本类型
	 * @author suwenguang
	 */
	void sendMsgAsync(String content) throws InterruptedException, ExecutionException, TimeoutException;

	/**
	 * 说明: 发送消息,默认文本类型,at特定人手机号码 string:("1XXXXX","2XXXXX")
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsgAt(String content, String atMobiles);

	/**
	 * 说明: 异步发送消息,默认文本类型,at特定人手机号码 string:("1XXXXX","2XXXXX")
	 * @author suwenguang
	 */
	void sendMsgAtAsync(String content, String atMobiles) throws InterruptedException, ExecutionException, TimeoutException;


	/**
	 * 说明: 发送消息,默认文本类型,at特定人手机号码,string
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsgAt(String content, List<String> atMobiles);


	/**
	 * 说明: 发送消息,默认文本类型,at所有人
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsgAtAll(String content);


	/**
	 * 说明: 发送不同类型的内容,默认不at人
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content);


	/**
	 * 说明: 所有内容自定义,详细内容查看钉钉 https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
	 *
	 * @author suwenguang
	 */
	ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content, List<String> atMobiles, Boolean isAtAll);
}
