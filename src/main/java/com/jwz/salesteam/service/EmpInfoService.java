package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.entity.EmpInfo;

import javax.servlet.http.HttpSession;
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

    String login(String emp_id, String emp_pwd, Integer emp_type, HttpSession httpSession);

    String updateEmpPwdById(String old_emp_pwd, String new_emp_pwd, Integer id);


    EmpInfoVO getPersonSaleman(EmpInfo empInfo);


}
