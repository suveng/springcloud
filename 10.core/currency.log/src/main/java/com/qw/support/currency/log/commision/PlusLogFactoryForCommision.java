package com.qw.support.currency.log.commision;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 基于logback日志扩展
 * 扩展自定义日志工厂,具体查看hutool文档
 * 设计模式UML 在项目的一级目录的AbstractLog.uml
 * @see LogFactory
 * @see cn.hutool.log.AbstractLog
 *
 * @author suwenguang
 */
public class PlusLogFactoryForCommision extends LogFactory {

	public PlusLogFactoryForCommision() {
		this(false);
	}

	/**
	 * 构造
	 *
	 * @param failIfNOP 如果未找到桥接包是否报错
	 */
	public PlusLogFactoryForCommision(boolean failIfNOP) {
		super("Slf4j");
		checkLogExist(LoggerFactory.class);
		if (false == failIfNOP) {
			return;
		}

		// SFL4J writes it error messages to System.err. Capture them so that the user does not see such a message on
		// the console during automatic detection.
		final StringBuilder buf = new StringBuilder();
		final PrintStream err = System.err;
		try {
			System.setErr(new PrintStream(new OutputStream() {
				@Override
				public void write(int b) {
					buf.append((char) b);
				}
			}, true, "US-ASCII"));
		} catch (UnsupportedEncodingException e) {
			throw new Error(e);
		}

		try {
			if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
				throw new NoClassDefFoundError(buf.toString());
			} else {
				err.print(buf);
				err.flush();
			}
		} finally {
			System.setErr(err);
		}
	}

	@Override
	public Log createLog(String name) {
		return new PlusLogForCommision(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new PlusLogForCommision(clazz);
	}

}
