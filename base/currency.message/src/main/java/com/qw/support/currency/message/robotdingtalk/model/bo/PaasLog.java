package com.qw.support.currency.message.robotdingtalk.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaasLog {
	private String link;
	private Long cost;
	private Boolean status;
	private String request;
	private String response;

	public PaasLog(String link, String request) {
		this.link = link;
		this.request = request;
	}

	@Override
	public String toString() {
		return "请求第三方API:" +
			"链接='" + link + '\'' +
			", 花费时间=" + cost +
			", 请求状态=" + status +
			", 请求参数='" + request + '\'' +
			", 请求返回='" + response + '\'';
	}
}
