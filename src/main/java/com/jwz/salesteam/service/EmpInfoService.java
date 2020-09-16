package com.jwz.salesteam.service;

import com.jwz.salesteam.entity.EmpInfo;

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
    public String saveEmpInfo(EmpInfo empInfo);
}
