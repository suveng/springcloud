package com.qw.support.currency.message.robotdingtalk.model.bo.message;

import lombok.Data;

/**
 * 基础消息封装
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public abstract class BaseMessage implements IMessage {
	protected String app;

	protected String phone;

	protected String profile;

	protected String link;

	protected String content;

	public abstract String toBeautiful();

}
