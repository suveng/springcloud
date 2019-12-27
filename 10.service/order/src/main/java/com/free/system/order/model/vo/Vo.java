package com.free.system.order.model.vo;

import com.qw.support.currency.result.Params;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * test
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class Vo {

	@NotBlank(message = "不能为空")
	private String appid;

	@NotBlank(message = "不能为空")
	private String key;

	@NotNull(message = "不能为空")
	private Long time;

	@NotBlank(message = "不能为空")
	private String version;


}
