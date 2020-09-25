package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.dao.OrderInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.service.AccountService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/25 15:53
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private EmpInfoMapper empInfoMapper;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    public EmpInfoVO searchByEmpdIdOrEmpName(String search) {
        Map<String,Long> empCountList;
        EmpInfo empInfo = empInfoMapper.selectByEmpName(search);

        if(empInfo == null){
            //用id查
            empInfo = empInfoMapper.selectByEmpId(search);
            empCountList = orderInfoService.getPersonSaleNum(search);
        }else{
            //用name查询
            empCountList = orderInfoService.getPersonSaleNum(empInfo.getEmpId());
        }
        EmpInfoVO empInfoVO = new EmpInfoVO();
        BeanUtil.copyProperties(empInfo,empInfoVO);
        empInfoVO.setEmpCountList(empCountList);
        return empInfoVO;
    }

    @Override
    public List<OrderConutVO> getAllCount() {
        List<OrderConutVO> empInfoList = BeanUtil.copyList(empInfoMapper.findEmpInfoList(), OrderConutVO.class);
        for(OrderConutVO orderConutVO:empInfoList){
            Integer empResults = orderInfoMapper.countByEmpId(orderConutVO.getEmpId());
            orderConutVO.setEmpResults(empResults);
        }
        return empInfoList;
    }
}
