package com.qw.support.currency.result;

import lombok.Data;

/**
 * description:
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class Params {
	private String appid;
	private String key;
	private Object data;
	private String version;
	private Long time;
}
