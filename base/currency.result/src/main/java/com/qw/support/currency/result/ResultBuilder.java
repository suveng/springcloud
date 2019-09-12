package com.qw.support.currency.result;


import cn.hutool.core.util.StrUtil;
import com.qw.support.currency.log.LogDetail;
import com.qw.support.currency.log.LogDetailThreadLocal;
import lombok.extern.slf4j.Slf4j;

/**
 * description: 统一返回层 工厂类
 *
 * @author suwenguang
 * @version 1.0.0
 */
@Slf4j
public class ResultBuilder {


	/**
	 * <p>build.</p>
	 *
	 * @param codeEnum a {@link CodeEnum} object.
	 * @param data a {@link Object} object.
	 * @return a {@link Result} object.
	 */
	public static Result build(CodeEnum codeEnum, Object data) {
		return build(codeEnum.getCode(), codeEnum.getMsg(), data);
	}


	/**
	 * <p>build.</p>
	 *
	 * @param code a int.
	 * @param msg a {@link String} object.
	 * @param data a {@link Object} object.
	 * @return a {@link Result} object.
	 */
	public static Result build(int code, String msg, Object data) {
		LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
		if (StrUtil.isBlank(logDetail.getRequsetId())) {
			log.warn(Thread.currentThread().getName() + "没有requestid");
		}
		return new Result(code, msg, data, logDetail.getRequsetId());
	}

}
