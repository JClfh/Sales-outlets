package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;

import java.util.List;

public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    GoodsInfo selectByName(String goodsName);

    List<GoodsInfo> findGoodsInfoList();

    GoodsInfo selectByNameAndId(String goodsName, Integer id);

    List<GoodsInfo> findByGoodsName(String goods_name);

    List<GoodsInfo> getGoodsInfoList();

    GoodsInfo getGoodsInfo(Integer id);

    GoodsInfo selectByGoodsName(String goods_id);

}