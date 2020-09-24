package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.SupplierInfo;

import java.util.List;

public interface SupplierInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierInfo record);

    int insertSelective(SupplierInfo record);

    SupplierInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierInfo record);

    int updateByPrimaryKey(SupplierInfo record);

    List<SupplierInfo> findSupplierInfoList();
}