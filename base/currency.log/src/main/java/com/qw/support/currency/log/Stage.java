package com.qw.support.currency.log;

/**
 * description: stage封装
 *
 * @author suwenguang
 * @since 1.0
 * @version 1.0.0
 */
@SuppressWarnings(value = "all")
public interface Stage {

	String PAAS = "服务调用";

	String CONSUMER = "消费数据";

	String PRODUCER = "生产数据";

	String AOP = "切面";

	String FILTER = "过滤器";

	String REQUEST = "接收请求";

	String RESPONSE = "返回结果";

	String PERMISSION = "鉴权";

	String CHECK = "校验";

	String READ = "查询数据";

	String WRITE = "写入数据";

	String UPDATE = "修改数据";

	String DELETE = "删除数据";

	String LOCK = "逻辑锁";

	String EXCEPTION = "异常";
}
