package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.GoodsList;

public interface GoodsListMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(GoodsList record);

    int insertSelective(GoodsList record);

    GoodsList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsList record);

    int updateByPrimaryKey(GoodsList record);
}