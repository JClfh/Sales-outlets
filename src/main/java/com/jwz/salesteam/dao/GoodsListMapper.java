package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.GoodsList;

import java.util.List;

public interface GoodsListMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(GoodsList record);

    int insertSelective(GoodsList record);

    GoodsList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsList record);

    int updateByPrimaryKey(GoodsList record);

    Integer selectByGoodsIdAndOrderId(String goods_id, String order_id);

    Integer sumCountPriceByOrderId(String order_id);

    List<GoodsList> selectByGoodsOrderId(String order_id);
}