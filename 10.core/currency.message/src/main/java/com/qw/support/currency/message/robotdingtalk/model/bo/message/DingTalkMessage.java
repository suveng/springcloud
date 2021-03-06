package com.qw.support.currency.message.robotdingtalk.model.bo.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DingTalkMessage extends BaseMessage {

	public DingTalkMessage(String profile, String content) {
		this.profile = profile;
		this.content = content;
	}

	public DingTalkMessage(String content) {
		this.content = content;
	}

	@PostConstruct
	public void init() {
		this.app = "校园招聘系统-campus";
	}

	/**
	 * description: 发送格式化钉钉消息
	 * author: suwenguang
	 * date: 2019-08-23
	 */
	@Override
	public String toBeautiful() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("app:").append(this.app).append("\n\n");
		stringBuilder.append("env: ").append(this.profile).append("\n\n");
		stringBuilder.append("content: ").append(this.content).append("\n\n");
		return stringBuilder.toString();
	}
}
