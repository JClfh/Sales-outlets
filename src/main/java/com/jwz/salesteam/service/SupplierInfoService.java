package com.jwz.salesteam.service;

import com.jwz.salesteam.entity.SupplierInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/24 13:27
 * @description：
 * @modified By：
 * @version:
 */
public interface SupplierInfoService {
    List<SupplierInfo> getSupplierInfoList();

    String saveSupplierInfo(SupplierInfo supplierInfo);

    String updateSupplierInfo(SupplierInfo supplierInfo);

    int delSupplierInfo(Integer id);

    List<SupplierInfo> findBySupplierName(String supplier_name);

    List<SupplierInfo> getSupplierInfoList2();

    String changeSupplierlock(Integer id, Integer is_del);
}
