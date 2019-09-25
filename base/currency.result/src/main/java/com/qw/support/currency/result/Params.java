package com.qw.support.currency.result;

import lombok.Data;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class Params<T> {
	/**
	 * 业务id,渠道id,客户端id
	 */
	private String appid;

	/**
	 * 秘钥
	 */
	private String key;

	/**
	 * 接口数据
	 */
	private T data;

	/**
	 * 接口版本
	 */
	private String version;

	/**
	 * 时间戳
	 */
	private Long time;
}
