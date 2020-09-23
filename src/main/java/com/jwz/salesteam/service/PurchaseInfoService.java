package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.PurchaseInfoVO;
import com.jwz.salesteam.entity.PurchaseInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/23 11:04
 * @description：
 * @modified By：
 * @version:
 */
public interface PurchaseInfoService {
    List<PurchaseInfoVO> getPersonMerchandiser(String emp_id);

    List<PurchaseInfoVO>  getPersonAccount(String accountEmpId);
}
