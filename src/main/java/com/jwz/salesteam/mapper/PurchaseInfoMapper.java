package com.jwz.salesteam.mapper;

import com.jwz.salesteam.entity.PurchaseInfo;
import com.jwz.salesteam.entity.PurchaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseInfoMapper {
    int countByExample(PurchaseInfoExample example);

    int deleteByExample(PurchaseInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseInfo record);

    int insertSelective(PurchaseInfo record);

    List<PurchaseInfo> selectByExample(PurchaseInfoExample example);

    PurchaseInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseInfo record, @Param("example") PurchaseInfoExample example);

    int updateByExample(@Param("record") PurchaseInfo record, @Param("example") PurchaseInfoExample example);

    int updateByPrimaryKeySelective(PurchaseInfo record);

    int updateByPrimaryKey(PurchaseInfo record);
}