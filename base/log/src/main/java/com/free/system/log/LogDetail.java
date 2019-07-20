package com.free.system.log;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/16
 * @version 1.0.0
 **/
@SuppressWarnings("all")
public class LogDetail implements ILogDetail {
	private static LogDetail logDetail = null;
	private String tag;
	private String requsetId;
	private String stage;
	private String msg;

	public LogDetail() {
	}

	public LogDetail(String tag, String requsetId, String stage) {
		this.tag = tag;
		this.requsetId = requsetId;
		this.stage = stage;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRequsetId() {
		return requsetId;
	}

	public void setRequsetId(String requsetId) {
		this.requsetId = requsetId;
	}

	/**
	 * 说明: 获取系统error的返回信息
	 * @author suwenguang
	 * @date 2019/7/17
	 * @return java.lang.String <- 返回类型
	 */
	@Override
	public String getRes() {
		return String.format("%s,requestid:%s", this.msg, this.requsetId);
	}

	/**
	 * 说明: 设置msg,采用format
	 * @author suwenguang
	 * @date 2019/7/17
	 * @return void <- 返回类型
	 */
	@Override
	public void setMsg(String format, Object... args) {
		this.msg = String.format(format, args);
	}

	/**
	 * 说明: 工厂方法,单例模式
	 * @author suwenguang
	 * @date 2019/7/17
	 * @return yiyou.tt.commision.core.common.logback.LogDetail <- 返回类型
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
	 * 说明: 日志规范
	 * @author suwenguang
	 * @date 2019/7/17
	 * @return java.lang.String <- 返回类型
	 */
	@Override
	public String toString() {
		return String.format("[%s]:%s:%s:%s", this.tag, this.requsetId, this.stage, this.msg);
	}
}
