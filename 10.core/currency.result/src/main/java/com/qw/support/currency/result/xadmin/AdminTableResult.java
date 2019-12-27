package com.qw.support.currency.result.xadmin;


import lombok.Data;

import java.util.List;

/**
 * description:
 *
 * @author suwenguang
 * @version 1.0.0
 */
@Data
public class AdminTableResult {
	/**
	 *返回码
	 */
	private Integer code;

	/**
	 * 返回消息
	 */
	private String msg;

	/**
	 * 条数
	 */
	private Long count;

	/**
	 * 数据
	 */
	private List data;


	/**
	 * <p>build.</p>
	 *
	 * @param codeEnum a {@link com.qw.support.currency.result.xadmin.AdminTableCodeEnum} object.
	 * @param data a {@link List} object.
	 * @param count a {@link Long} object.
	 * @return a {@link AdminTableResult} object.
	 */
	public static AdminTableResult build(AdminTableCodeEnum codeEnum, List data, Long count) {
		AdminTableResult adminTableResult = new AdminTableResult();
		adminTableResult.setCode(codeEnum.getCode());
		adminTableResult.setMsg(codeEnum.getMsg());
		adminTableResult.setData(data);
		adminTableResult.setCount(count);
		return adminTableResult;
	}
}
