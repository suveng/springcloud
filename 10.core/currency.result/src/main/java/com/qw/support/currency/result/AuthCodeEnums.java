package com.qw.support.currency.result;

/**
 * description:
 *
 * @author suwenguang
 * @version 1.0.0
 */
public enum AuthCodeEnums {
	/**
	 * 	没登录
	 */
	NO_LOGIN(1, "没登录"),

	/**
	 * shiro异常,获取不到subject
	 */
	SHIRO_ERROR(2, "shiro异常"),

	/**
	 * 没有角色
	 */
	NO_ROLE(3, "没有角色"),

	/**
	 * 没有权限
	 */
	NO_PERMIT(4, "没有权限");

	/**
	 * 对应码
	 */
	private Integer code;

	/**
	 * 对应描述
	 */
	private String msg;

	/**
	 * 构造器
	 * @param code 对应码
	 * @param msg 对应描述
	 */
	AuthCodeEnums(Integer code, String msg) {
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
