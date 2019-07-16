package com.free.system.response;

import java.util.Date;

/**
 * description:
 * @author suwenguang
 * @date 2019/6/9
 * @version 1.0.0
 **/
public class OtherResponseDemo extends Response  {
    private String time;

    public OtherResponseDemo() {
        this.time = new Date().toString();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
