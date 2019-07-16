package com.free.system.log;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/16
 * @version 1.0.0
 **/
@SuppressWarnings("all")
public class LogDetail implements ILogDetail {
    private static LogDetail logDetail = null;
    private String tag;
    private String requsetId;
    private String stage;
    private String msg;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequsetId() {
        return requsetId;
    }

    public void setRequsetId(String requsetId) {
        this.requsetId = requsetId;
    }

    @Override
    public String getRes() {
        return String.format("%s,requestid:%s", this.msg, this.requsetId);
    }

    @Override
    public void setMsg(String format, Object... args) {
        this.msg = String.format(format, args);
    }

    public static LogDetail build() {
        if (logDetail == null) {
            synchronized (ILogDetail.class) {
                if (logDetail == null) {
                    return new LogDetail();
                }
            }
        }
        return logDetail;
    }

    @Override
    public String toString() {
        return String.format("[%s]:%s:%s:%s", this.tag, this.requsetId, this.stage, this.msg);
    }
}
