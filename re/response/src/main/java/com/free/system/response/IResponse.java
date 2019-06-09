package com.free.system.response;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/9
 * @version 1.0.0
 **/
public interface IResponse {
    public Integer getCode();

    public String getMsg();

    public Object getData();

    public void setCode(Integer code);

    public void setMsg(String msg);

    public void setData(Object data);
}
