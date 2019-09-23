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

	/**
	 * 无参构造器,默认设置thread name
	 */
	public LogDetail() {
		this.threadName = Thread.currentThread().getName();
	}

	/**
	 * 设置tag,requestid,stage,thread name的构造器
	 * @param tag 日志标签
	 * @param requsetId 唯一标识id
	 * @param stage 处理阶段
	 */
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
	public static LogDetail get() {
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
		StringBuffer stringBuffer = new StringBuffer();
		if (StrUtil.isNotBlank(this.tag)) {
			stringBuffer.append("[").append(this.tag).append("]##");
		}
		if (StrUtil.isNotBlank(this.stage)) {
			stringBuffer.append(this.stage).append("##");
		}
		if (StrUtil.isNotBlank(this.method)) {
			stringBuffer.append(this.method).append("##");
		}
		if (StrUtil.isNotBlank(msg)) {
			stringBuffer.append(this.msg).append("##");
		}
		if (StrUtil.isNotBlank(this.requsetId)) {
			stringBuffer.append(this.requsetId).append("##");
		}
		return StrUtil.isBlank(stringBuffer.toString()) ? "空串" : stringBuffer.toString();
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
