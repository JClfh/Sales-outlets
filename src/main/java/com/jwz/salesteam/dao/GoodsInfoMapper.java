package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.GoodsInfo;

public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}