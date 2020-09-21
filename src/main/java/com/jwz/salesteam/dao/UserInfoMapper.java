package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> findUserInfoList();

    List<UserInfo> findByUserName(String user_name);

    UserInfo selectByTelAndId(String user_tel, Integer id);
}