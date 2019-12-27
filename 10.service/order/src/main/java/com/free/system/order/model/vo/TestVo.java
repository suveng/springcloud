package com.free.system.order.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * test
 * @author suwenguang
 * @version 1.0.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class TestVo extends Vo{
	@Valid
	private Test data;
}

@Data
class Test{
	@NotNull(message = "不能为空")
	private String name;
}
