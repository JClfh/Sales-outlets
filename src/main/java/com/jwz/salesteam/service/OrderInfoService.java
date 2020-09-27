package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;
import com.jwz.salesteam.controller.common.OrderDetailInfoVO;
import com.jwz.salesteam.controller.common.UserOrderInfoVO;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.util.Result;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    String saveOrderInfo(OrderInfo orderInfo);

    String updateOrdersState(String order_id, int status);

    List<OrderInfo> getOrdersInfoList();

    List<UserOrderInfoVO> getOrdersInfoList2(String emp_id);

    Map<String,Long> getPersonSaleNum(String emp_id);


    OrderDetailInfoVO findByOrderDetail(String order_id);
}
