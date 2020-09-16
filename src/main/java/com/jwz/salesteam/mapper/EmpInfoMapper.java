package com.jwz.salesteam.mapper;

import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.EmpInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpInfoMapper {
    int countByExample(EmpInfoExample example);

    int deleteByExample(EmpInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmpInfo record);

    int insertSelective(EmpInfo record);

    List<EmpInfo> selectByExample(EmpInfoExample example);

    EmpInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmpInfo record, @Param("example") EmpInfoExample example);

    int updateByExample(@Param("record") EmpInfo record, @Param("example") EmpInfoExample example);

    int updateByPrimaryKeySelective(EmpInfo record);

    int updateByPrimaryKey(EmpInfo record);
}