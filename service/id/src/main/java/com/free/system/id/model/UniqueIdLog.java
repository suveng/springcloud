package com.free.system.id.model;

import java.io.Serializable;
import java.util.Date;

public class UniqueIdLog implements Serializable {
    /**
     *  id
     */
    private Long id;

    /**
     *  表示业务，因为整体系统中会有很多业务需要生成ID，这样可以共用一张表维护
     */
    private String bizTag;

    /**
     *  现在整体系统中已经分配的最大ID
     */
    private Long maxId;

    /**
     *  描述
     */
    private String desc;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     *  修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizTag() {
        return bizTag;
    }

    public void setBizTag(String bizTag) {
        this.bizTag = bizTag;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}