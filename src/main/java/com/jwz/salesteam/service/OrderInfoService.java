package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;
import com.jwz.salesteam.entity.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    String saveOrderInfo(OrderInfo orderInfo);

    String updateOrdersState(String order_id, int status);

    List<OrderInfo> getOrdersInfoList();

    List<OrderInfo> getOrdersInfoList2(String emp_id);

    Map<String,Long> getPersonSaleNum(String emp_id);




}
