package com.free.system.response;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/2/26
 * description: 统一返回层 工厂类
 **/
public class ResponseBuilder {
    /**
     * 创建方法
     * @param responseEnums 错误枚举
     * @param data 返回数据
     */
    public static Response build(IResponseEnums responseEnums, Object data) {
        return new Response(responseEnums, data);
    }

}
