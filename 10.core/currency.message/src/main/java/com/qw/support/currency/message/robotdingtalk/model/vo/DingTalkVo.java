package com.qw.support.currency.message.robotdingtalk.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
public class DingTalkVo {
	private String msgtype;
	private DingTalkText text;
	private DingTalkAt at;


	public DingTalkVo(String msgtype, String content, List<String> atMobiles, Boolean isAtALl) {
		this.msgtype = msgtype;
		this.text = new DingTalkText();
		this.text.content = content;
		this.at = new DingTalkAt();
		this.at.atMobiles = atMobiles;
		this.at.isAtAll = isAtALl;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public DingTalkText getText() {
		return text;
	}

	public void setText(DingTalkText text) {
		this.text = text;
	}

	public DingTalkAt getAt() {
		return at;
	}

	public void setAt(DingTalkAt at) {
		this.at = at;
	}

	public static class DingTalkText {

		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

	public static class DingTalkAt {

		private boolean isAtAll;
		private List<String> atMobiles;

		public boolean isIsAtAll() {
			return isAtAll;
		}

		public void setIsAtAll(boolean isAtAll) {
			this.isAtAll = isAtAll;
		}

		public List<String> getAtMobiles() {
			return atMobiles;
		}

		public void setAtMobiles(List<String> atMobiles) {
			this.atMobiles = atMobiles;
		}
	}
}
