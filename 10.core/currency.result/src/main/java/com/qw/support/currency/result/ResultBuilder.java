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
@SuppressWarnings("all")
public class ResultBuilder {


	/**
	 * 根据serviceResult构造返回结果
	 * @author suwenguang
	 * @param serviceResult 服务结果
	 * @return result
	 */
	public static Result build(ServiceResult serviceResult) {
		return build(serviceResult.getCode(), serviceResult.getMsg(), serviceResult.getData());
	}

	/**
	 * 根据枚举生成返回结果
	 * @author suwenguang
	 * @param codeEnum 系统代码
	 * @param data  数据
	 * @return result
	 */
	public static Result build(CodeEnum codeEnum, Object data) {
		return build(codeEnum.getCode(), codeEnum.getMsg(), data);
	}


	/**
	 * 直接构造
	 * @author suwenguang
	 * @param code 系统代码
	 * @param data  数据
	 * @param msg 说明
	 * @return result
	 */
	public static Result build(int code,String msg, Object data) {
		LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
		if (StrUtil.isBlank(logDetail.getRequsetId())) {
			log.warn(Thread.currentThread().getName() + "没有requestid");
		}
		return new Result(code, msg, data, logDetail.getRequsetId());
	}

}
