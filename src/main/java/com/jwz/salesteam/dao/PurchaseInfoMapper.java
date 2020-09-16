package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.PurchaseInfo;

public interface PurchaseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseInfo record);

    int insertSelective(PurchaseInfo record);

    PurchaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseInfo record);

    int updateByPrimaryKey(PurchaseInfo record);
}