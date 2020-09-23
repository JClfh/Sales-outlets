package com.jwz.salesteam.controller.common;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/22 20:24
 * @description：
 * @modified By：
 * @version:
 */
public class ShoppingCartList {

    private String goodsId;

    private Integer goodsNum;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public ShoppingCartList(String goodsId, Integer goodsNum) {
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }

    public ShoppingCartList() {
    }

    @Override
    public String toString() {
        return "ShoppingCartList{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsNum=" + goodsNum +
                '}';
    }
}
