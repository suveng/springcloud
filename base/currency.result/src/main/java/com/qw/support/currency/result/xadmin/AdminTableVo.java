package com.qw.support.currency.result.xadmin;

import lombok.Data;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class AdminTableVo {
	/**
	 * 分页页数
	 */
	private Integer page;

	/**
	 * 每页条数
	 */
	private Integer limit;

	/**
	 * 开始创建时间
	 */
	private String startCreateTime;

	/**
	 * 结束创建时间
	 */
	private String endCreateTime;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 学校
	 */
	private String school;

	/**
	 * 申请岗位
	 */
	private String applyJob;

	/**
	 * 申请类型
	 */
	private String applyType;
}
