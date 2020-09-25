package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.OrderListVO;
import com.jwz.salesteam.controller.common.PurchaseInfoVO;
import com.jwz.salesteam.entity.PurchaseInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/23 11:04
 * @description：
 * @modified By：
 * @version:
 */


public interface PurchaseInfoService {
    List<OrderListVO> getPersonMerchandiser(String emp_id);

    List<OrderListVO>  getPersonAccount(String accountEmpId);

    String savePurchaseInfo(PurchaseInfo purchaseInfo);

    List<OrderListVO>  getPurchaseInfoList();

    String updatePurchaseState(String purchase_id, int status, HttpSession httpSession);

    String updatePurchaseInfo(PurchaseInfo purchaseInfo);

    List<OrderListVO> getPurchaseInfoReqList();
}
