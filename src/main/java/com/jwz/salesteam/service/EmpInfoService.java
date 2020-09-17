package com.jwz.salesteam.service;

import com.jwz.salesteam.entity.EmpInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/16 15:57
 * @description：职工管理服务
 * @modified By：
 * @version: 1.0
 */

public interface EmpInfoService {

    /**
     *添加职员
     */
    String saveEmpInfo(EmpInfo empInfo);

    String updateEmpInfo(EmpInfo empInfo);

    int delEmpInfo(Integer id);

    List <EmpInfo> getEmpList();

    EmpInfo selectByEmpId(String emp_id);

    List<EmpInfo> findByEmpName(String emp_name);
}
