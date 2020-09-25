package com.jwz.salesteam.dao;

import com.jwz.salesteam.entity.PurchaseInfo;
import io.swagger.models.auth.In;

import java.util.Date;
import java.util.List;

public interface PurchaseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseInfo record);

    int insertSelective(PurchaseInfo record);

    PurchaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseInfo record);

    int updateByPrimaryKey(PurchaseInfo record);

    List<PurchaseInfo> selectByEmpId(String emp_id);

    List<PurchaseInfo> selectByAccountEmpId(String accountEmpId);

    List<PurchaseInfo> findPurchaseInfoList();

    int updatePurchaseState(String purchase_id, Integer status);

    int updateFinishTime(String purchase_id,Date finishTime);

    List<PurchaseInfo> findPurchaseInfoByOrderId(String orderId, Integer is_del,Integer status);

    PurchaseInfo selectByPurchaseId(String purchase_id);

    int updateAccountEmpId(String purchase_id,String account_emp_id);
}