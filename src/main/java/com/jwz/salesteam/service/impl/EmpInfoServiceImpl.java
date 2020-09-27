package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private OrderInfoService orderInfoService;

    @Override
    public String saveEmpInfo(EmpInfo empInfo) {
        EmpInfo temp = empInfoMapper.selectByTel(empInfo.getEmpTel());

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
       // EmpInfo temp2 = empInfoMapper.selectByTelAndNameAndId(empInfo.getEmpTel(), empInfo.getEmpName(),empInfo.getId());
       // System.out.println(empInfo.getEmpTel()+"---"+empInfo.getId());
        EmpInfo temp3 = empInfoMapper.selectByTelAndId(empInfo.getEmpTel(),empInfo.getId());
        if (temp3 != null) {
            //同一个电话且不同id 不能继续修改
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

    @Override
    public String login(String emp_id, String emp_pwd, Integer emp_type, HttpSession httpSession) {
        EmpInfo empInfo = empInfoMapper.selectByLoginNameAndPwdAndType(emp_id, emp_pwd,emp_type);
        if (empInfo != null && httpSession != null) {
            if (empInfo.getIsLock() == 1) {
                return ServiceResultEnum.LOGIN_EMP_LOCKED.getResult();
            }

//            NewBeeMallUserVO newBeeMallUserVO = new NewBeeMallUserVO();
//            BeanUtil.copyProperties(user, newBeeMallUserVO);
//            //设置购物车中的数量
            if(emp_type == 0){
                httpSession.setAttribute("销售员", empInfo);

            }else if(emp_type == 1){
                httpSession.setAttribute("跟单员", empInfo);

            }else if(emp_type == 2){
                httpSession.setAttribute("财务人员", empInfo);
            }

            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    @Override
    public String updateEmpPwdById(String old_emp_pwd, String new_emp_pwd, Integer id) {
        EmpInfo temp = empInfoMapper.selectByPrimaryKey(id);
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if(!temp.getEmpPwd().equals(old_emp_pwd)){
            return ServiceResultEnum.OLD_EMP_PWD_ERROR.getResult();
        }
        temp.setUpdateTime(new Date());
        if (empInfoMapper.updateEmpPwdByPrimaryKey(new_emp_pwd,id) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();

    }

    @Override
    public EmpInfoVO getPersonSaleman(EmpInfo empInfo) {
        Map<String,Long> empCountList = orderInfoService.getPersonSaleNum(empInfo.getEmpId());
        EmpInfoVO empInfoVO = new EmpInfoVO();
        BeanUtil.copyProperties(empInfo,empInfoVO);
        empInfoVO.setEmpCountList(empCountList);
        return empInfoVO;
    }

    @Override
    public String Adminlogin(String emp_id, String emp_pwd, HttpSession httpSession) {
        EmpInfo empInfo = empInfoMapper.selectByLoginNameAndPwd(emp_id, emp_pwd);
        if (empInfo != null) {
//            if (empInfo.getIsLock() == 1) {
//                return ServiceResultEnum.LOGIN_EMP_LOCKED.getResult();
//            }
            httpSession.setAttribute("admin", empInfo);
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    @Override
    public String changelock(Integer id, Integer is_lock) {
        if (empInfoMapper.changelock(id,is_lock) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
