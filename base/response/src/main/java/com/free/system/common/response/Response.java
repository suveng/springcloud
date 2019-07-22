package com.free.system.common.response;

import lombok.*;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/2/26
 * description: 统一返回层
 **/
@SuppressWarnings("all")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Response  {
	/**
	 * 错误码
	 */
	@NonNull
	private String code;

	/**
	 * 错误描述
	 **/
	@NonNull
	private String msg;

	/**
	 * 返回数据
	 **/
	private Object data;
}
