package com.free.system.response;

import lombok.extern.slf4j.Slf4j;

/**
 * @author suwenguang
 * email suveng@163.com
 * since 2019/2/26
 * description: 统一返回层 工厂类
 **/
@Slf4j
public class ResponseBuilder {
    /**
     * 创建方法
     * @param responseEnums 错误枚举
     * @param data 返回数据
     */
    public static IResponse build(IResponseEnums responseEnums, Object data) {
        return new Response(responseEnums, data);
    }

    /**
     * 说明: 处理扩展的response实例, 例如 com.free.system.response.OtherResponseDemo
     * @see     OtherResponseDemo
     * @author  suwenguang
     * @date    2019/6/9
     * @return  com.free.system.response.IResponse <- 返回类型
     */
    public static IResponse build(Class<? extends Response> response,IResponseEnums responseEnums, Object data)  {
        IResponse res = null;
        try {
            res = response.newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            log.error("获取实例失败",e);
            return new Response(responseEnums,data);
        }
        res.setCode(responseEnums.getCode());
        res.setMsg(responseEnums.getDescription());
        res.setData(data);
        return res;
    }

}