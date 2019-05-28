package com.free.system.service.common.modules.user.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     *  id编号
     */
    private Integer id;

    /**
     *  用户账号
     */
    private String username;

    /**
     *  加密的密码
     */
    private String password;

    /**
     *  盐值
     */
    private String salt;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     *  修改时间
     */
    private Date modifyTime;


    /**
     * token
     **/
    private String token;

    /**
     *  是否被逻辑删除(1,已经删除;0,未删除)
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
