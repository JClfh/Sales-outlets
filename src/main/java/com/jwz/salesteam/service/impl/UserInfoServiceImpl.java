package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.UserInfoVO;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.dao.UserInfoMapper;
import com.jwz.salesteam.entity.UserInfo;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/21 8:42
 * @description：
 * @modified By：
 * @version:
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private EmpInfoMapper empInfoMapper;

    @Override
    public String updateUserInfo(UserInfo userInfo) {
        UserInfo temp = userInfoMapper.selectByPrimaryKey(userInfo.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        // EmpInfo temp2 = empInfoMapper.selectByTelAndNameAndId(empInfo.getEmpTel(), empInfo.getEmpName(),empInfo.getId());
        // System.out.println(empInfo.getEmpTel()+"---"+empInfo.getId());
        UserInfo temp3 = userInfoMapper.selectByTelAndId(userInfo.getUserTel(),userInfo.getId());
        if (temp3 != null) {
            //同一个电话且不同id 不能继续修改
            return ServiceResultEnum.SAME_USERINFO_EXIST.getResult();
        }
        userInfo.setUpdateTime(new Date());
        if (userInfoMapper.updateByPrimaryKeySelective(userInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public int delUserInfo(Integer id) {
        UserInfo temp = userInfoMapper.selectByPrimaryKey(id);
        if(temp == null){
            return 0;
        }

        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserInfoVO> getUserInfoList() {

        List<UserInfoVO> userInfoVOList =  new ArrayList<>();
        userInfoVOList =  BeanUtil.copyList(userInfoMapper.findUserInfoList(), UserInfoVO.class);
        for(UserInfoVO userInfoVO:userInfoVOList){
            String firstEmpName = empInfoMapper.selectByPrimaryKey(userInfoVO.getFirstSaleman()).getEmpName();
            String lastEmpName = empInfoMapper.selectByPrimaryKey(userInfoVO.getLastSaleman()).getEmpName();
            userInfoVO.setFirstSalemanName(firstEmpName);
            userInfoVO.setLastSalemanName(lastEmpName);
        }
        return userInfoVOList;
    }

    @Override
    public List<UserInfo> findByUserName(String user_name) {
        return userInfoMapper.findByUserName(user_name);
    }
}
