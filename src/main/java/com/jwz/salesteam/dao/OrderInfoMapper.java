package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.entity.OrderInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int updateOrdersState(String order_id, Integer status);

    int updateFinishTime(String order_id, Date date);

    List<OrderInfo> findOrdersInfoList();

    List<OrderInfo> findOrdersInfoList2(String emp_id);


    List<Map<String,Object>> personalCountByEmpId(String emp_id);

    Integer countByEmpId(String emp_id);

    List<String> findOrdersIdList();

    List<String> findFinishOrdersIdList();

    Integer findOrderStatusByOrderId(String order_id);
}