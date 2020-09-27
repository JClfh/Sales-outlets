package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.*;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    String saveOrderInfo(ShoppingCartItemVO shoppingCartItemVO, HttpSession httpSession);

    String updateOrdersState(String order_id, int status);

    List<OrderInfo> getOrdersInfoList();

    List<UserOrderInfoVO> getOrdersInfoList2(String emp_id);

    Map<String,Long> getPersonSaleNum(String emp_id);


    OrderDetailInfoVO findByOrderDetail(String order_id);
}
