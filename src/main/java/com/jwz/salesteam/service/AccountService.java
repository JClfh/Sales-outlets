package com.jwz.salesteam.service;

import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/25 15:52
 * @description：
 * @modified By：
 * @version:
 */
public interface AccountService {
    List<OrderConutVO> getAllCount();

    EmpInfoVO searchByEmpdIdOrEmpName(String search);
}
