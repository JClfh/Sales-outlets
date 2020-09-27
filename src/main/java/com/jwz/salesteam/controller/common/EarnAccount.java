package com.jwz.salesteam.controller.common;

import java.util.Date;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/25 17:22
 * @description：
 * @modified By：
 * @version:
 */
public class EarnAccount {

    private String orderId;

    private Date createTime;

    private Integer takeInPrice;

    private Integer earnMoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTakeInPrice() {
        return takeInPrice;
    }

    public void setTakeInPrice(Integer takeInPrice) {
        this.takeInPrice = takeInPrice;
    }

    public Integer getEarnMoney() {
        return earnMoney;
    }

    public void setEarnMoney(Integer earnMoney) {
        this.earnMoney = earnMoney;
    }
}
