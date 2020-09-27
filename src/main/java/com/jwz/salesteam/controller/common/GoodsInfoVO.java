package com.jwz.salesteam.controller.common;

import java.util.Date;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/26 20:03
 * @description：
 * @modified By：
 * @version:
 */
public class GoodsInfoVO {

    private Integer id;

    private String goodsId;

    private String goodsName;

    private Integer goodsSellingPrice;

    private Integer goodsCostPrice;

    private Integer goodsPrice;

    private String goodsCoverImg;

    private String goodsDetailContent;

    private String goodsIntro;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;

    private Integer status;

    private Integer goodsNum;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsSellingPrice() {
        return goodsSellingPrice;
    }

    public void setGoodsSellingPrice(Integer goodsSellingPrice) {
        this.goodsSellingPrice = goodsSellingPrice;
    }

    public Integer getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(Integer goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCoverImg() {
        return goodsCoverImg;
    }

    public void setGoodsCoverImg(String goodsCoverImg) {
        this.goodsCoverImg = goodsCoverImg;
    }

    public String getGoodsDetailContent() {
        return goodsDetailContent;
    }

    public void setGoodsDetailContent(String goodsDetailContent) {
        this.goodsDetailContent = goodsDetailContent;
    }

    public String getGoodsIntro() {
        return goodsIntro;
    }

    public void setGoodsIntro(String goodsIntro) {
        this.goodsIntro = goodsIntro;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "GoodsInfoVO{" +
                "id=" + id +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSellingPrice=" + goodsSellingPrice +
                ", goodsCostPrice=" + goodsCostPrice +
                ", goodsPrice=" + goodsPrice +
                ", goodsCoverImg='" + goodsCoverImg + '\'' +
                ", goodsDetailContent='" + goodsDetailContent + '\'' +
                ", goodsIntro='" + goodsIntro + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                ", status=" + status +
                ", goodsNum=" + goodsNum +
                '}';
    }
}
