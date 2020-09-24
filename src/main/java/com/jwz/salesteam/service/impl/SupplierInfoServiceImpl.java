package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.dao.SupplierInfoMapper;
import com.jwz.salesteam.entity.SupplierInfo;
import com.jwz.salesteam.service.SupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/24 13:27
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {

    @Autowired
    private SupplierInfoMapper supplierInfoMapper;

    @Override
    public List<SupplierInfo> getSupplierInfoList() {
        return supplierInfoMapper.findSupplierInfoList();
    }
}
