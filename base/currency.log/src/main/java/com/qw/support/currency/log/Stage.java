package com.qw.support.currency.log;

/**
 * description: stage封装
 *
 * @author suwenguang
 * @since 1.0
 * @version 1.0.0
 */
@SuppressWarnings(value = "all")
public interface Stage {
	/** Constant <code>REQUEST="接收请求"</code> */
	String REQUEST = "接收请求";
	/** Constant <code>RESPONSE="返回结果"</code> */
	String RESPONSE = "返回结果";
	/** Constant <code>CHECK="校验"</code> */
	String CHECK = "校验";
	/** Constant <code>READ="查询数据"</code> */
	String READ = "查询数据";
	/** Constant <code>WRITE="写入数据"</code> */
	String WRITE = "写入数据";
	/** Constant <code>UPDATE="修改数据"</code> */
	String UPDATE = "修改数据";
	/** Constant <code>DELETE="删除数据"</code> */
	String DELETE = "删除数据";
	/** Constant <code>LOCK="逻辑锁"</code> */
	String LOCK = "逻辑锁";
	/** Constant <code>EXCEPTION="异常"</code> */
	String EXCEPTION = "异常";
}
