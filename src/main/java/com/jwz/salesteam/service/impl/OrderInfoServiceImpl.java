package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;
import com.jwz.salesteam.controller.common.UserInfoVO;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.dao.OrderInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.service.OrderListService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.NumberUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;



    @Autowired
    private EmpInfoMapper empInfoMapper;
    
    @Override
    public String saveOrderInfo(OrderInfo orderInfo) {

        String order_id =  NumberUtil.genOrderNo();
        orderInfo.setOrderId(order_id);

        if (orderInfoMapper.insertSelective(orderInfo) > 0) {
            //创建商品列表
            return ServiceResultEnum.SUCCESS.getResult();

        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }

    @Override
    public String updateOrdersState(String order_id, int status) {
        if (status == 4){
            orderInfoMapper.updateFinishTime(order_id,new Date());
        }
        if (orderInfoMapper.updateOrdersState(order_id,status) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public List<OrderInfo> getOrdersInfoList() {
        return orderInfoMapper.findOrdersInfoList();
    }

    @Override
    public List<OrderInfo> getOrdersInfoList2(String emp_id) {
        return orderInfoMapper.findOrdersInfoList2(emp_id);
    }

    @Override
    public  Map<String,Long> getPersonSaleNum(String emp_id) {
        List<Map<String,Object>> list = orderInfoMapper.personalCountByEmpId(emp_id);
        Map<String,Long> res = new HashMap<>();
        for (Map<String,Object> stringStringMap : list) {
            System.out.println(stringStringMap.toString());

            String month = null;
            Long empCount = null;

            for (Map.Entry<String,Object> entry:stringStringMap.entrySet()){
                if ("month".equals(entry.getKey())){
                    month = (String)entry.getValue();
                }else {
                    empCount = (Long)entry.getValue();
                }
            }

            res.put(month,empCount);
        }
        return res;
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


