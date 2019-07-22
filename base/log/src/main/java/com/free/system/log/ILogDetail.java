package com.free.system.log;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public interface ILogDetail {
	@Override
	String toString();

	/**
	 * 说明: 获取接口返回的消息
	 * @return java.lang.String <- 返回类型
	 */
	String getRes();

	/**
	 * 说明: 设置信息
	 * @return void <- 返回类型
	 */
	LogDetail setMsg(String format, Object... arg);

}
