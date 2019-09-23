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

	public ServiceResult(T data) {
		this.data = data;
	}

}

