package com.qw.support.currency.result;

import lombok.Data;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public abstract class AbstractResult {
	/**
	 * 返回码
	 */
	protected Integer code;

	/**
	 * 返回描述
	 */
	protected String msg;


}
