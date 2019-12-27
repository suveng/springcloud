package com.qw.support.currency.result.xadmin;

/**
 * description:
 *
 * @author suwenguang
 * @version 1.0.0
 */
public enum AdminTableCodeEnum {
	/**
	 *	成功
	 */
	SUCCESS(0,"成功"),

	/**
	 * 异常
	 */
	EXCEPTION(5000,"异常"),

	/**
	 * 参数错误
	 */
	CLIENT_EXCEPTION(4000,"客户端传参错误"),
	;
	/**
	 * 对应码
	 */
	private Integer code;
	/**
	 * 对应描述
	 */
	private String msg;

	AdminTableCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * <p>Getter for the field <code>code</code>.</p>
	 *
	 * @return a {@link Integer} object.
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * <p>Getter for the field <code>msg</code>.</p>
	 *
	 * @return a {@link String} object.
	 */
	public String getMsg() {
		return msg;
	}
}
