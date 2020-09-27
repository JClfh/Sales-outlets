package com.jwz.salesteam.entity;

import java.util.Date;

public class OrderInfo {
    private Integer id;

    private String orderId;

    private String empId;

    private String userId;

    private Integer takeInPrice;

    private Integer modeOfDistibution;

    private Integer status;

    private Date createTime;

    private Date finishTime;

    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getTakeInPrice() {
        return takeInPrice;
    }

    public void setTakeInPrice(Integer takeInPrice) {
        this.takeInPrice = takeInPrice;
    }

    public Integer getModeOfDistibution() {
        return modeOfDistibution;
    }

    public void setModeOfDistibution(Integer modeOfDistibution) {
        this.modeOfDistibution = modeOfDistibution;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", empId='" + empId + '\'' +
                ", userId='" + userId + '\'' +
                ", takeInPrice=" + takeInPrice +
                ", modeOfDistibution=" + modeOfDistibution +
                ", status=" + status +
                ", createTime=" + createTime +
                ", finishTime=" + finishTime +
                ", isDel=" + isDel +
                '}';
    }
}