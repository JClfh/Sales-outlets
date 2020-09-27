package com.jwz.salesteam.controller.common;

import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.entity.UserInfo;

import java.util.Date;
import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/26 19:31
 * @description：
 * @modified By：
 * @version:
 */
public class OrderDetailInfoVO {

    private String empName;

    private String orderId;

    private List<GoodsInfoVO> goodsInfoVOList;

    private UserInfo userInfo;

    private Integer takeInPrice;

    private Integer allPrice;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<GoodsInfoVO> getGoodsInfoVOList() {
        return goodsInfoVOList;
    }

    public void setGoodsInfoVOList(List<GoodsInfoVO> goodsInfoVOList) {
        this.goodsInfoVOList = goodsInfoVOList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getTakeInPrice() {
        return takeInPrice;
    }

    public void setTakeInPrice(Integer takeInPrice) {
        this.takeInPrice = takeInPrice;
    }

    public Integer getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Integer allPrice) {
        this.allPrice = allPrice;
    }
}
