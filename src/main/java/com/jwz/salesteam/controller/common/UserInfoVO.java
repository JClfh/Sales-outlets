package com.jwz.salesteam.controller.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/21 10:49
 * @description：
 * @modified By：
 * @version:
 */
public class UserInfoVO  implements Serializable {
    private Integer id;

    private String userName;

    private Integer userSex;

    private String userTel;

    private Integer userVip;

    private String userAddress;

    private Integer firstSaleman;

    private Integer lastSaleman;

    private String firstSalemanName;

    private String lastSalemanName;

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

    public Integer getLastSaleman() {
        return lastSaleman;
    }

    public void setLastSaleman(Integer lastSaleman) {
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

    public String getFirstSalemanName() {
        return firstSalemanName;
    }

    public void setFirstSalemanName(String firstSalemanName) {
        this.firstSalemanName = firstSalemanName;
    }

    public String getLastSalemanName() {
        return lastSalemanName;
    }

    public void setLastSalemanName(String lastSalemanName) {
        this.lastSalemanName = lastSalemanName;
    }

    public UserInfoVO(Integer id, String userName, Integer userSex, String userTel, Integer userVip, String userAddress, Integer firstSaleman, Integer lastSaleman, String firstSalemanName, String lastSalemanName, Date createTime, Date updateTime, Integer isDel) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userVip = userVip;
        this.userAddress = userAddress;
        this.firstSaleman = firstSaleman;
        this.lastSaleman = lastSaleman;
        this.firstSalemanName = firstSalemanName;
        this.lastSalemanName = lastSalemanName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDel = isDel;
    }

    public UserInfoVO() {
    }
}
