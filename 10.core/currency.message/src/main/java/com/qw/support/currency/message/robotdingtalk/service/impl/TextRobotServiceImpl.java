package com.qw.support.currency.message.robotdingtalk.service.impl;


import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.qw.support.currency.message.robotdingtalk.model.AbstractInitRobot;
import com.qw.support.currency.message.robotdingtalk.model.bo.DingTalkResult;
import com.qw.support.currency.message.robotdingtalk.model.bo.PaasLog;
import com.qw.support.currency.message.robotdingtalk.model.interfaces.InitRobot;
import com.qw.support.currency.message.robotdingtalk.model.vo.DingTalkVo;
import com.qw.support.currency.message.robotdingtalk.service.IRobotService;
import com.qw.support.currency.result.ServiceResult;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Slf4j
public class TextRobotServiceImpl extends AbstractInitRobot implements IRobotService, InitRobot {

	private static final String TEXT = "text";

	/**
	 * 钉钉的机器人链接
	 */
	private String link;

	/**
	 * 队列
	 */
	private ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1000, true);

	/**
	 * 线程池
	 */
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS,
		workQueue, ThreadFactoryBuilder.create().setNamePrefix("dingtalk-message-").build(), new ThreadPoolExecutor.DiscardPolicy());


	@Override
	public IRobotService init(String link) {
		this.link = link;
		return this;
	}

	@Override
	public void sendMsgAsync(String content) throws InterruptedException, ExecutionException, TimeoutException {
		sendMsgTypeAsync(TEXT,content,null,false);
	}

	@Override
	public void sendMsgAtAsync(String content, String atMobiles) throws InterruptedException, ExecutionException, TimeoutException {
		sendMsgTypeAsync(TEXT,content,new ArrayList<>(Arrays.asList(atMobiles.split(","))),false);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsg(String content) {
		return sendMsgType(TEXT, content);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsgAt(String content, String atMobiles) {
		//校验
		if (!StrUtil.hasBlank(atMobiles)) {
			return sendMsgType(TEXT, content, new ArrayList<>(Arrays.asList(atMobiles.split(","))), false);
		}
		return sendMsgType(TEXT, content);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsgAt(String content, List<String> atMobiles) {
		return sendMsgType(TEXT,content,atMobiles,false);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsgAtAll(String content) {
		return sendMsgType(TEXT, content,null,true);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content) {
		return sendMsgType(msgtype, content, null, false);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsgType(String msgtype, String content, List<String> atMobiles, Boolean isatall) {
		ServiceResult<DingTalkResult> res = new ServiceResult<>();
		//校验
		long start = System.nanoTime();
		if (StrUtil.hasBlank(link, msgtype, content)) {
			res.setPass(false);
			return res;
		}
		//发送
		DingTalkVo dingTalkVo = new DingTalkVo(msgtype, content, atMobiles, isatall);
		log.debug("vo2json:{}", JSON.toJSONString(dingTalkVo));


		PaasLog paasLog = new PaasLog(link, JSON.toJSONString(dingTalkVo));
		try {
			String result = HttpRequest.post(link)
				.body(JSON.toJSONString(dingTalkVo))
				.execute().body();
			paasLog.setStatus(true);
			paasLog.setResponse(result);

			res.setData(JSON.parseObject(result, DingTalkResult.class));
		} catch (HttpException e) {
			paasLog.setStatus(false);
			paasLog.setResponse(e.getMessage());

			res.setPass(false);
			res.setMsg(e.getMessage());
		} finally {
			paasLog.setCost((System.nanoTime() - start) / 1000000);
			log.info(paasLog.toString());
		}

		res.setPass(true);
		//成功处理
		return res;
	}

	/**
	 * 异步发送钉钉消息
	 * @param msgtype 消息类型
	 * @param content 内容
	 * @param atMobiles 手机号
	 * @param isatall at全部人
	 * @throws InterruptedException 中断异常
	 * @throws ExecutionException 执行异常
	 * @throws TimeoutException 超时异常
	 */
	private void sendMsgTypeAsync(String msgtype, String content, List<String> atMobiles, Boolean isatall) throws InterruptedException, ExecutionException, TimeoutException {
		Runnable runnable = () -> sendMsgType(msgtype,content,atMobiles,isatall);
		executor.execute(runnable);
	}


}
