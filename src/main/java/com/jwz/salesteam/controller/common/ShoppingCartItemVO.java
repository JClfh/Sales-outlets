package com.jwz.salesteam.controller.common;

import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.entity.UserInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/27 12:49
 * @description：
 * @modified By：
 * @version:
 */
public class ShoppingCartItemVO {
    private UserInfo userInfo;

    private List<GoodsInfoVO> goodsInfoVOList;

    private OrderInfo orderInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<GoodsInfoVO> getGoodsInfoVOList() {
        return goodsInfoVOList;
    }

    public void setGoodsInfoVOList(List<GoodsInfoVO> goodsInfoVOList) {
        this.goodsInfoVOList = goodsInfoVOList;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
