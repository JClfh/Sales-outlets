package com.jwz.salesteam.entity;

import java.util.Date;

public class PurchaseInfo {
    private Integer id;

    private String purchaseId;

    private String supplierId;

    private String supplierName;

    private Integer goodsPrice;

    private String orderId;

    private String goodsId;

    private String empId;

    private String accountEmpId;

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

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAccountEmpId() {
        return accountEmpId;
    }

    public void setAccountEmpId(String accountEmpId) {
        this.accountEmpId = accountEmpId;
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

    public PurchaseInfo(){

    }
    public PurchaseInfo(String purchaseId, String supplierId, String supplierName, Integer goodsPrice, String orderId, String goodsId, String empId, String accountEmpId, Integer status, Date createTime, Date finishTime, Integer isDel) {

        this.purchaseId = purchaseId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.goodsPrice = goodsPrice;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.empId = empId;
        this.accountEmpId = accountEmpId;
        this.status = status;
        this.createTime = createTime;
        this.finishTime = finishTime;
        this.isDel = isDel;
    }
}
