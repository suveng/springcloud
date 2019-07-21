package com.free.system.response;

import cn.hutool.core.util.RandomUtil;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/2/26
 * description: 统一返回层
 **/
@SuppressWarnings("all")
public class Response implements IResponse {
	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 错误描述
	 **/
	private String msg;

	/**
	 * 返回数据
	 **/
	private Object data;


	Response(IResponseEnums responseEnums, Object data) {
		this.code = responseEnums.getCode() + RandomUtil.randomInt(6);
		this.msg = responseEnums.getDescription();
		this.data = data;
	}

	public Response(Integer code, String msg, Object data) {
		this.code = code + RandomUtil.randomInt(6);
		this.msg = msg;
		this.data = data;
	}


	public Response() {
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object data) {
		this.data = data;
	}
}
