package com.free.base.dingtalkrobot.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSON;
import com.free.base.dingtalkrobot.model.DingTalkResult;
import com.free.base.dingtalkrobot.model.DingTalkVo;
import com.free.base.dingtalkrobot.model.ServiceResult;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Slf4j
public class TextRobotServiceImpl extends AbstractInitRobot implements IRobotService,InitRobot {
	private String link;

	@Override
	public IRobotService init(String link) {
		this.link = link;
		return this;
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsg(String content) {
		return sendMsg("text", content);
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsg(String msgtype, String content) {
		return null;
	}

	@Override
	public ServiceResult<DingTalkResult> sendMsg(String msgtype, String content, List<String> atMobiles, Boolean isAtALl) {
		ServiceResult<DingTalkResult> res = new ServiceResult<>();
		//校验
		long start = System.nanoTime();
		if (StrUtil.hasBlank(link, msgtype, content)) {
			res.setResult(false);
			return res;
		}
		//发送
		DingTalkVo dingTalkVo = new DingTalkVo(msgtype, content, atMobiles, isAtALl);
		log.debug("vo2json:{}", JSON.toJSONString(dingTalkVo));


		PaasLog paasLog = new PaasLog(link, JSON.toJSONString(dingTalkVo));
		try {
			String result = HttpRequest.post(link)
				.body(JSON.toJSONString(dingTalkVo))
				.execute().body();
			paasLog.setStatus(true);
			paasLog.setResponse(result);

			res.setData(JSON.parseObject(result,DingTalkResult.class));
		} catch (HttpException e) {
			paasLog.setStatus(false);
			paasLog.setResponse(e.getMessage());

			res.setResult(false);
			res.setMsg(e.getMessage());
		} finally {
			paasLog.setCost((System.nanoTime() - start) / 1000000);
			log.info(paasLog.toString());
		}

		res.setResult(true);
		//成功处理
		return res;
	}
}
