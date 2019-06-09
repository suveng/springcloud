package com.free.system.response;

/**
 * description: 系统错误描述接口
 * @author suwenguang
 * @date 2019/6/8
 * @version 1.0.0
 **/
public interface IResponseEnums {
    /**
     * 说明: 获取错误码
     * @author  suwenguang
     * @date    2019/6/8
     * @return  java.lang.Integer <- 返回类型
     */
    Integer getCode();


    /**
     * 说明: 获取错误描述
     * @author  suwenguang
     * @date    2019/6/8
     * @return  java.lang.String <- 返回类型
     */
    String getDescription();

}
