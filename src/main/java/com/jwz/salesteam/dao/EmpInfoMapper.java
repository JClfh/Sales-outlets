package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.EmpInfo;

import java.util.List;

public interface EmpInfoMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EmpInfo record);

    int insertSelective(EmpInfo record);

    EmpInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpInfo record);

    int updateByPrimaryKey(EmpInfo record);

    EmpInfo selectByTelAndNameAndId(String emp_tel ,String emp_name,Integer id);

    EmpInfo selectByEmpId(String emp_id);

    List<EmpInfo> findEmpInfoList();

    List<EmpInfo> findByEmpName(String emp_name);

    EmpInfo selectByTel(String empTel);

    EmpInfo selectByTelAndId(String emp_tel, Integer id);

    EmpInfo selectByLoginNameAndPwdAndType(String emp_id, String emp_pwd, Integer emp_type);

    int updateEmpPwdByPrimaryKey(String emp_pwd, Integer id);

    EmpInfo selectByEmpName(String search);

    EmpInfo selectByLoginNameAndPwd(String emp_id, String emp_pwd);

    int changelock(Integer id,Integer is_lock);

}