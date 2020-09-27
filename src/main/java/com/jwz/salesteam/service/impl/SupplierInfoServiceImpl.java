package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.dao.SupplierInfoMapper;
import com.jwz.salesteam.entity.SupplierInfo;
import com.jwz.salesteam.service.SupplierInfoService;
import com.jwz.salesteam.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public String saveSupplierInfo(SupplierInfo supplierInfo) {
        SupplierInfo temp = supplierInfoMapper.selectByName(supplierInfo.getSupplierName());

        if (temp != null) {
            return ServiceResultEnum.SAME_SUPPLIERINFO_EXIST.getResult();
//            return "该职员已经存在";
        }
        String supplier_id =  NumberUtil.genSupplierId();

        supplierInfo.setSupplierId(supplier_id);
        if (supplierInfoMapper.insertSelective(supplierInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateSupplierInfo(SupplierInfo supplierInfo) {
        SupplierInfo temp = supplierInfoMapper.selectByPrimaryKey(supplierInfo.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }

        SupplierInfo temp3 = supplierInfoMapper.selectByNameAndId(supplierInfo.getSupplierName(),supplierInfo.getId());
        if (temp3 != null) {
            //同一个电话且不同id 不能继续修改
            return ServiceResultEnum.SAME_EMPINFO_EXIST.getResult();
        }
        supplierInfo.setUpdateTime(new Date());
        if (supplierInfoMapper.updateByPrimaryKeySelective(supplierInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public int delSupplierInfo(Integer id) {
        SupplierInfo temp = supplierInfoMapper.selectByPrimaryKey(id);
        if(temp == null){
            return 0;
        }

        return supplierInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SupplierInfo> findBySupplierName(String supplier_name) {
        return supplierInfoMapper.findBySupplierName(supplier_name);
    }

    @Override
    public List<SupplierInfo> getSupplierInfoList2() {
        return supplierInfoMapper.findSupplierInfoList2();
    }

    @Override
    public String changeSupplierlock(Integer id, Integer is_del) {
        if (supplierInfoMapper.changelock(id,is_del) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
