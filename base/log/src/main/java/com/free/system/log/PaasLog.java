package com.free.system.log;

import lombok.*;

/**
 * description: 第三方服务调用日志
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PaasLog {

	/**
	 * 唯一id,自增
	 **/
	private String id;


	/**
	 * 用户id
	 **/
	@NonNull
	private String userId;


	/**
	 * 业务id
	 **/
	private String appId;

	/**
	 * 云服务名称,比如聚合数据,阿里云
	 */
	private String paasName;

	/**
	 * 具体服务名称,比如银行卡二要素校验
	 */
	private String paasServiceName;

	/**
	 * 调用的链接
	 */
	@NonNull
	private String paasServiceLink;

	/**
	 * 请求的参数
	 */
	@NonNull
	private Object requst;

	/**
	 * 返回的结果
	 */
	@NonNull
	private Object response;

	private String voDetail;


	/**
	 * 调用花费的时间
	 */
	@NonNull
	private String costTime;

	/**
	 * 调用状态,自定义是成功还是失败
	 */
	private String status;


}
