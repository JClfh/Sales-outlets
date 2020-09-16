package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/16 15:57
 * @description：职工管理服务
 * @modified By：
 * @version: 1.0
 */
@Service
public class EmpInfoServiceImpl implements EmpInfoService {

    @Autowired
    private EmpInfoMapper empInfoMapper;

    @Override
    public String saveEmpInfo(EmpInfo empInfo) {
        EmpInfo temp = empInfoMapper.selectByTelAndName(empInfo.getEmpTel(), empInfo.getEmpName());
        if (temp != null) {
            return ServiceResultEnum.SAME_EMPINFO_EXIST.getResult();
//            return "该职员已经存在";
        }
        if (empInfoMapper.insertSelective(empInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }
}
