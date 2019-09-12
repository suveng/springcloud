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
public class LogDetail implements ILogDetail {
	private static LogDetail logDetail = null;


	/**
	 * 线程名称
	 **/
	private String threadName;

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
	 * <p>Getter for the field <code>userId</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <p>Setter for the field <code>userId</code>.</p>
	 *
	 * @param userId a {@link String} object.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * <p>Setter for the field <code>threadName</code>.</p>
	 *
	 * @param threadName a {@link String} object.
	 * @return a {@link LogDetail} object.
	 */
	public LogDetail setThreadName(String threadName) {
		this.threadName = threadName;
		return this;
	}

	/**
	 * <p>Setter for the field <code>stage</code>.</p>
	 *
	 * @param stage a {@link String} object.
	 * @return a {@link LogDetail} object.
	 */
	public LogDetail setStage(String stage) {
		this.stage = stage;
		return this;
	}

	/**
	 * <p>Setter for the field <code>tag</code>.</p>
	 *
	 * @param tag a {@link String} object.
	 * @return a {@link LogDetail} object.
	 */
	public LogDetail setTag(String tag) {
		this.tag = tag;
		return this;

	}

	/**
	 * <p>Setter for the field <code>msg</code>.</p>
	 *
	 * @param msg a {@link String} object.
	 * @return a {@link LogDetail} object.
	 */
	public LogDetail setMsg(String msg) {
		this.msg = msg;
		return this;

	}

	/**
	 * <p>Setter for the field <code>requsetId</code>.</p>
	 *
	 * @param requsetId a {@link String} object.
	 * @return a {@link LogDetail} object.
	 */
	public LogDetail setRequsetId(String requsetId) {
		this.requsetId = requsetId;
		return this;

	}

	/**
	 * {@inheritDoc}
	 *
	 * 说明: 设置msg,采用format
	 * @author suwenguang
	 */
	@Override
	public LogDetail setMsg(String format, Object... args) {
		this.msg = String.format(format, args);
		return this;

	}


	/**
	 * <p>Constructor for LogDetail.</p>
	 */
	public LogDetail() {
		this.threadName = Thread.currentThread().getName();
	}

	/**
	 * <p>Constructor for LogDetail.</p>
	 *
	 * @param tag a {@link String} object.
	 * @param requsetId a {@link String} object.
	 * @param stage a {@link String} object.
	 */
	public LogDetail(String tag, String requsetId, String stage) {
		this.tag = tag;
		this.requsetId = requsetId;
		this.stage = stage;
		this.threadName = Thread.currentThread().getName();
	}

	/**
	 * <p>Getter for the field <code>threadName</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getThreadName() {
		return threadName;
	}


	/**
	 * <p>Getter for the field <code>stage</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getStage() {
		return stage;
	}


	/**
	 * <p>Getter for the field <code>tag</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getTag() {
		return tag;
	}


	/**
	 * <p>Getter for the field <code>msg</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * <p>Getter for the field <code>requsetId</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getRequsetId() {
		return requsetId;
	}


	/**
	 * {@inheritDoc}
	 *
	 * 说明: 获取系统error的返回信息
	 * @author suwenguang
	 */
	@Override
	public String getRes() {
		return String.format("%s,requestid:%s", this.msg, this.requsetId);
	}


	/**
	 * 说明: 工厂方法,单例模式
	 *
	 * @author suwenguang
	 * @return a {@link LogDetail} object.
	 */
	public static LogDetail build() {
		if (logDetail == null) {
			synchronized (ILogDetail.class) {
				if (logDetail == null) {
					return new LogDetail();
				}
			}
		}
		return logDetail;
	}

	/**
	 * {@inheritDoc}
	 *
	 * 说明: 日志规范
	 * @author suwenguang
	 */
	@Override
	public String toString() {
		String tagStr = this.tag;
		String stageStr = this.stage;
		String msgStr = this.msg;
		String requsetIdStr = this.requsetId;

		if (StrUtil.isBlank(tagStr)){
			String str = "默认";
			tagStr= str;
		}
		if (StrUtil.isBlank(stageStr)){
			String str = "默认";
			stageStr= str;
		}
		if (StrUtil.isBlank(msgStr)){
			String str = "默认";
			msgStr= str;
		}
		if (StrUtil.isBlank(requsetIdStr)){
			String str = "默认";
			requsetIdStr= str;
		}

		return String.format("[%s]:%s:%s:requestid=%s", tagStr, stageStr, msgStr, requsetIdStr);
	}
}
