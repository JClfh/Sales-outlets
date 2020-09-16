package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.OrderInfo;

public interface OrderInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}