package com.qw.support.currency.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>Result class.</p>
 *
 * @author suwenguang
 *         suveng@163.com
 * description: 统一返回层
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Result extends AbstractResult implements Serializable {
	/**
	 * 返回数据
	 */
	private Object data;

	/**
	 * 唯一请求id
	 */
	private String requestId;


	/**
	 * 构造方法
	 * @param code 返回码
	 * @param msg 返回信息
	 * @param data 返回数据
	 * @param requestId 唯一请求id
	 */
	public Result(Integer code, String msg, Object data, String requestId) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.requestId = requestId;
	}

	public Result() {
	}
}
