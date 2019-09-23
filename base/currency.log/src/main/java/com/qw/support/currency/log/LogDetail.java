package com.qw.support.currency.log;

import cn.hutool.core.util.StrUtil;

/**
 * description: 日志实体
 *
 * @author suwenguang
 * @since 1.0
 * @version 1.0.0
 */
@SuppressWarnings("all")
public class LogDetail {


	/**
	 * 线程名称
	 **/
	private String threadName;

	/**
	 * 方法名称
	 */
	private String method;
	/**
	 * 标签
	 **/
	private String tag;

	/**
	 * 本地请求id
	 **/
	private String requsetId;

	/**
	 * 代码阶段
	 **/
	private String stage;

	/**
	 * 日志信息
	 **/
	private String msg;

	/**
	 * 用户id
	 */
	private String userId;

	public LogDetail() {
		this.threadName = Thread.currentThread().getName();
	}

	public LogDetail(String tag, String requsetId, String stage) {
		this.tag = tag;
		this.requsetId = requsetId;
		this.stage = stage;
		this.threadName = Thread.currentThread().getName();
	}

	/**
	 * 获取当前线程的logdetail对象
	 * @return LogDetail
	 */
	public LogDetail get(){
		LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
		logDetail.setThreadName(Thread.currentThread().getName());
		return logDetail;
	}

	/**
	 * 格式化日志
	 * @param format 格式demo
	 * @param args 参数
	 * @return LogDetail
	 */
	public LogDetail setMsg(String format, Object... args) {
		this.msg = String.format(format, args);
		return this;

	}


	/**
	 * 格式化输出
	 * @return String
	 */
	@Override
	public String toString() {
		String tagStr = this.tag;
		String stageStr = this.stage;
		String msgStr = this.msg;
		String requsetIdStr = this.requsetId;
		String methodStr = this.method;

		if (StrUtil.isBlank(tagStr)) {
			tagStr = "默认";
		}
		if (StrUtil.isBlank(stageStr)) {
			stageStr = "默认";
		}
		if (StrUtil.isBlank(msgStr)) {
			msgStr = "默认";
		}
		if (StrUtil.isBlank(requsetIdStr)) {
			requsetIdStr = "默认";
		}
		if (StrUtil.isBlank(method)) {
			methodStr = "默认";
		}
		return String.format("[%s]:method=%s:stage=%s:msg=%s:requestid=%s", tagStr, methodStr, stageStr, msgStr, requsetIdStr);
	}

	/**
	 * 获取简单的返回
	 * @return
	 */
	public String getRes() {
		return String.format("%s,requestid:%s", this.msg, this.requsetId);
	}

	public String getMethod() {
		return method;
	}

	public LogDetail setMethod(String method) {
		this.method = method;
		return this;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LogDetail setThreadName(String threadName) {
		this.threadName = threadName;
		return this;
	}


	public LogDetail setStage(String stage) {
		this.stage = stage;
		return this;
	}


	public LogDetail setTag(String tag) {
		this.tag = tag;
		return this;

	}


	public LogDetail setMsg(String msg) {
		this.msg = msg;
		return this;

	}

	public LogDetail setRequsetId(String requsetId) {
		this.requsetId = requsetId;
		return this;

	}


	public String getThreadName() {
		return threadName;
	}


	public String getStage() {
		return stage;
	}


	public String getTag() {
		return tag;
	}


	public String getMsg() {
		return msg;
	}


	public String getRequsetId() {
		return requsetId;
	}


}
