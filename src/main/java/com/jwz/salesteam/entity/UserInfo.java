package com.jwz.salesteam.entity;

import java.util.Date;

public class UserInfo {

    private Integer id;

    private String userName;

    private Integer userSex;

    private String userTel;

    private Integer userVip;

    private String userAddress;

    private Integer firstSaleman;

    private String lastSaleman;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserVip() {
        return userVip;
    }

    public void setUserVip(Integer userVip) {
        this.userVip = userVip;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getFirstSaleman() {
        return firstSaleman;
    }

    public void setFirstSaleman(Integer firstSaleman) {
        this.firstSaleman = firstSaleman;
    }

    public String getLastSaleman() {
        return lastSaleman;
    }

    public void setLastSaleman(String lastSaleman) {
        this.lastSaleman = lastSaleman;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}