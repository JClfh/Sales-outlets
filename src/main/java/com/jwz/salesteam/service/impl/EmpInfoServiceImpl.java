package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        String emp_id =  NumberUtil.genEmpId();
        EmpInfo temp1 = selectByEmpId(emp_id);
        //防止随机ID重复
        while (temp1 != null){
            emp_id =  NumberUtil.genEmpId();
            temp1 = selectByEmpId(emp_id);
        }
        empInfo.setEmpId(emp_id);
        empInfo.setEmpPwd(emp_id);
        if (empInfoMapper.insertSelective(empInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }

    @Override
    public String updateEmpInfo(EmpInfo empInfo) {
        EmpInfo temp = empInfoMapper.selectByPrimaryKey(empInfo.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        EmpInfo temp2 = empInfoMapper.selectByTelAndName(empInfo.getEmpTel(), empInfo.getEmpName());
        if (temp2 != null) {
            //同名且不同id 不能继续修改
            return ServiceResultEnum.SAME_EMPINFO_EXIST.getResult();
        }
        empInfo.setUpdateTime(new Date());
        if (empInfoMapper.updateByPrimaryKeySelective(empInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public int delEmpInfo(Integer id) {
        EmpInfo temp = empInfoMapper.selectByPrimaryKey(id);
        if(temp == null){
            return 0;
        }

        return empInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<EmpInfo> getEmpList() {
        return empInfoMapper.findEmpInfoList();
    }

    @Override
    public EmpInfo selectByEmpId(String emp_id) {
        return empInfoMapper.selectByEmpId(emp_id);
    }

    @Override
    public List<EmpInfo> findByEmpName(String emp_name) {
        return empInfoMapper.findByEmpName(emp_name);
    }
}
