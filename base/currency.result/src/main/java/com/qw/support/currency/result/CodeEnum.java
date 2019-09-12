package com.qw.support.currency.result;

/**
 * description:
 *
 * @author suwenguang
 * @version 1.0.0
 */
public enum CodeEnum {
	/**
	 * 	成功
	 */
	SUCCESS(2000, "成功"),

	/**
	 * 异常
	 */
	EXCEPTION(5000, "未知异常"),

	/**
	 * 自定义系统异常
	 */
	SYS_EXCEPTION(5001, "自定义系统异常"),

	/**
	 * 参数错误
	 */
	CLIENT_EXCEPTION(4000, "客户端错误"),

	/**
	 * cas
	 */
	CAS_FAIL(4001, "CAS验证失败"),

	/**
	 * 操作失败
	 */
	OPERATION_FAIL(6000, "操作失败"),

	/**
	 * 需要验证码
	 */
	NEED_SMS_CODE(6001, "需要验证码"),


	/**
	 * 验证码错误
	 */
	SMS_CODE_ERROR(6002, "验证码错误"),


	/**
	 * 创建文件失败
	 */
	CREATE_FILE_ERROR(6003, "创建文件失败"),

	/**
	 * 获取openid失败
	 */
	OPENID_ERROR(6004, "获取openid失败"),

	/**
	 * 文件太大了
	 */
	FILE_TO_LARGE(6005, "文件太大了"),

	/**
	 * 需要登录
	 */
	NEED_LOGIN(6006, "需要登录"),


	/**
	 * 脏数据
	 */
	DIRTY_DATA(7000, "脏数据"),

	/**
	 * 一个手机号只能绑定一个账号
	 */
	PHONE_UNIQUE(7001, "一个手机号只能绑定一个账号"),

	/**
	 * 助力对象找不到
	 */
	TARGET_NOT_FOUND(7002, "找不到助力对象"),

	/**
	 * 只能助力一次
	 */
	ONLY_HELP_ONCE(7003, "只能助力一次"),

	/**
	 * 不要重复添加
	 */
	NO_REPEAT_ADD(7004, "不要重复添加"),

	/**
	 * 用户找不到
	 */
	NOT_FOUND(7005, "找不到用户"),

	/**
	 * 并发,降级
	 */
	CONCURRENT(8001, "稍后再试"),

	;

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
	CodeEnum(Integer code, String msg) {
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
