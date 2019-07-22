package com.free.system.spring.advice;


import com.free.system.ResponseEnums;
import com.free.system.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

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
	 * 方法:  handleSQLException
	 * @author suwenguang
	 * @date 2019/5/23
	 *
	 * @param e (类型:Exception )
	 * @return Result
	 */
	@ExceptionHandler({DataAccessException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Response handleSQLException(SQLException e) {
		logger.error("统一异常处理:数据库SQL异常", e);
		return new Response(ResponseEnums.SQL_ERROR.getCode(), "数据库SQL异常" + e.getMessage(), e.getCause());
	}

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
	public Response handleException(Exception e) {
		logger.error("统一异常处理:系统发生异常", e);
		return new Response(ResponseEnums.UNKNOWN_ERROR.getCode(), "系统发生异常", e.getMessage());
	}
}
