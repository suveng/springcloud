package com.qw.support.currency.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description:
 *
 * @author suwenguang
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceResult<T> extends AbstractResult {
	/**
	 * 内部方法返回结果
	 */
	private boolean pass;

	/**
	 * 内部方法返回的数据
	 */
	private T data;

	public ServiceResult() {
	}

	private ServiceResult(T data) {
		this.data = data;
	}

	private ServiceResult(Integer code, String msg, T data) {
		this.pass = false;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private ServiceResult(boolean pass, Integer code, String msg, T data) {
		this.pass = pass;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 根据codeEnum构造,默认pass为false,注意
	 * @author suwenguang
	 * @param codeEnum 系统代码
	 * @param data 数据
	 * @return serviceResult
	 */
	public static <T> ServiceResult<T> build(CodeEnum codeEnum, T data) {
		return new ServiceResult<>(false, codeEnum.getCode(), codeEnum.getMsg(), data);
	}

	/**
	 * 根据codeEnum构造,默认pass为false,注意
	 * @author suwenguang
	 * @param codeEnum 系统代码
	 * @param pass 服务状态
	 * @param data 数据
	 * @return serviceResult
	 */
	public static <T> ServiceResult<T> build(boolean pass, CodeEnum codeEnum, T data) {
		return new ServiceResult<>(pass, codeEnum.getCode(), codeEnum.getMsg(), data);
	}

	/**
	 * 配置属性值
	 * @author suwenguang
	 * @param codeEnum 系统代码
	 * @param pass 状态
	 */
	public void set(boolean pass, CodeEnum codeEnum) {
		this.pass = pass;
		this.setCode(codeEnum.getCode());
		this.setMsg(codeEnum.getMsg());
	}


	/**
	 * 配置属性值
	 * @author suwenguang
	 * @param codeEnum 系统代码
	 */
	public void set(CodeEnum codeEnum) {
		this.setCode(codeEnum.getCode());
		this.setMsg(codeEnum.getMsg());
	}

	/**
	 * 配置属性值
	 * @author suwenguang
	 * @param data 数据
	 * @param codeEnum 系统代码
	 *
	 */
	public void set(CodeEnum codeEnum, T data) {
		this.setCode(codeEnum.getCode());
		this.setMsg(codeEnum.getMsg());
		this.setData(data);
	}


}

