package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.controller.common.EarnAccount;
import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.OrderConutVO;
import com.jwz.salesteam.dao.EmpInfoMapper;
import com.jwz.salesteam.dao.GoodsListMapper;
import com.jwz.salesteam.dao.OrderInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.service.AccountService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private GoodsListMapper goodsListMapper;
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
    public List<EarnAccount> earnAccount() {
        List<EarnAccount> orderList = BeanUtil.copyList(orderInfoMapper.findOrdersEarnList(),EarnAccount.class);
        for(EarnAccount earnAccount:orderList){
         Integer earnMoney = earnAccount.getTakeInPrice() - goodsListMapper.sumCountPriceByOrderId(earnAccount.getOrderId());
         earnAccount.setEarnMoney(earnMoney);
        }
        List<EarnAccount> orderList1 = new ArrayList<>();

        for(int i = 0  ; i < orderList.size() ;i++){
            EarnAccount temp = orderList.get(i);
            int flag = 0;
            int flagj = 0;
            for(int j = 0 ; j< orderList1.size() ; j++){
                EarnAccount  temp1 = orderList1.get(j);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dt = simpleDateFormat.format(temp.getCreateTime());
                String dt2 = simpleDateFormat.format(temp1.getCreateTime());
//                Date date1  = simpleDateFormat.parse(dt);
//                Date date2  = simpleDateFormat.parse(dt2);
//                System.out.println(i+"----"+j+"-----"+dt+"----"+dt2);
                if(dt.equals(dt2)){
                    flag = 1;
                    flagj = j;
                }
            }
            if(flag == 1){ //里面有了
                EarnAccount  temp2 = orderList1.get(flagj);
                temp2.setEarnMoney(temp2.getEarnMoney()+ temp.getEarnMoney());
                temp2.setTakeInPrice(temp2.getTakeInPrice()+ temp.getTakeInPrice());

            }else{ //里面没有就加进去
                orderList1.add(temp);
            }
        }
        return orderList1;
    }

    @Override
    public List<EarnAccount> earnMonthAccount() {
        List<EarnAccount> orderList = BeanUtil.copyList(orderInfoMapper.findOrdersMonthEarnList(),EarnAccount.class);
        for(EarnAccount earnAccount:orderList){
            Integer earnMoney = earnAccount.getTakeInPrice() - goodsListMapper.sumCountPriceByOrderId(earnAccount.getOrderId());
            earnAccount.setEarnMoney(earnMoney);
        }
        List<EarnAccount> orderList1 = new ArrayList<>();

        for(int i = 0  ; i < orderList.size() ;i++){
            EarnAccount temp = orderList.get(i);
            int flag = 0;
            int flagj = 0;
            for(int j = 0 ; j< orderList1.size() ; j++){
                EarnAccount  temp1 = orderList1.get(j);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
                String dt = simpleDateFormat.format(temp.getCreateTime());
                String dt2 = simpleDateFormat.format(temp1.getCreateTime());
//                System.out.println(dt+"----"+dt2);
                if(dt.equals(dt2)){
                    flag = 1;
                    flagj = j;
                }
            }
            if(flag == 1){ //里面有了
                EarnAccount  temp2 = orderList1.get(flagj);
                temp2.setEarnMoney(temp2.getEarnMoney()+ temp.getEarnMoney());
                temp2.setTakeInPrice(temp2.getTakeInPrice()+ temp.getTakeInPrice());

            }else{ //里面没有就加进去

                orderList1.add(temp);
            }
        }
        return orderList1;
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
