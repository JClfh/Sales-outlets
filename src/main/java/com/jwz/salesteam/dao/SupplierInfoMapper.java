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

    List<SupplierInfo>  findSupplierInfoList2();

    SupplierInfo selectByName(String supplier_name);

    List<SupplierInfo> findBySupplierName(String supplier_name);

    SupplierInfo selectByNameAndId(String supplier_name, Integer id);

    int changelock(Integer id, Integer is_del);
}