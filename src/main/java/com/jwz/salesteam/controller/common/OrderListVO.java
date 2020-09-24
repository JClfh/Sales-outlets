package com.jwz.salesteam.controller.common;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/24 13:45
 * @description：
 * @modified By：
 * @version:
 */
public class OrderListVO {
    private String orderId;

    private List<PurchaseInfoVO> purchaseInfoVO;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<PurchaseInfoVO> getPurchaseInfoVO() {
        return purchaseInfoVO;
    }

    public void setPurchaseInfoVO(List<PurchaseInfoVO> purchaseInfoVO) {
        this.purchaseInfoVO = purchaseInfoVO;
    }
}
