package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.dao.UserInfoMapper;
import com.jwz.salesteam.entity.UserInfo;
import com.jwz.salesteam.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<UserInfo> getUserInfoList() {
        return userInfoMapper.findUserInfoList();
    }

    @Override
    public List<UserInfo> findByUserName(String user_name) {
        return userInfoMapper.findByUserName(user_name);
    }
}
