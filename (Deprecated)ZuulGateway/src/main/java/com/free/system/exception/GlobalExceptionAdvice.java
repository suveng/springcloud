package com.free.system.exception;


import com.qw.support.currency.result.CodeEnum;
import com.qw.support.currency.result.Result;
import com.qw.support.currency.result.ResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description:
 * @author suwenguang
 * @date 2019/5/24
 * @version 1.0.0
 **/
@RestControllerAdvice
public class GlobalExceptionAdvice {

	/** Field logger  */
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);


	/**
	 * 方法:  handleIndexOutOfBoundsException
	 *
	 * @author suwenguang
	 * @date 2019/5/20
	 *
	 *
	 * @param e (类型:Exception )
	 * @return Result
	 */
	@ExceptionHandler({Exception.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Result handleException(Exception e) {
		logger.error("统一异常处理:系统发生异常", e);
		return ResultBuilder.build(CodeEnum.EXCEPTION, "");
	}
}
