package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.EmpInfo;

public interface EmpInfoMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EmpInfo record);

    int insertSelective(EmpInfo record);

    EmpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpInfo record);

    int updateByPrimaryKey(EmpInfo record);

    EmpInfo selectByTelAndName(String emp_tel ,String emp_name);
}