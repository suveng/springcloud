package com.qw.support.currency.message.robotdingtalk.model.enums;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public enum  DingTalkResultEnums {
	/**
	 * ok
	 */
	SUCCESS(0L,"ok"),
	;

	DingTalkResultEnums() {
	}

	DingTalkResultEnums(Long errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	private Long errcode;
	private String errmsg;

	public Long getErrcode() {
		return errcode;
	}

	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}}
