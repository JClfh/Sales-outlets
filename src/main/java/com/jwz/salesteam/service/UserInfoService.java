package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.UserInfoVO;
import com.jwz.salesteam.entity.UserInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/21 8:38
 * @description：客户服务
 * @modified By：
 * @version: 1.0
 */
public interface UserInfoService {


    String updateUserInfo(UserInfo userInfo);

    int delUserInfo(Integer id);

    List<UserInfoVO> getUserInfoList();

    List<UserInfo> findByUserName(String user_name);

}
