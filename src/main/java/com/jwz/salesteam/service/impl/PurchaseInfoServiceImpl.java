package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.OrderListVO;
import com.jwz.salesteam.controller.common.PurchaseInfoVO;
import com.jwz.salesteam.controller.common.UserInfoVO;
import com.jwz.salesteam.dao.GoodsInfoMapper;
import com.jwz.salesteam.dao.GoodsListMapper;
import com.jwz.salesteam.dao.OrderInfoMapper;
import com.jwz.salesteam.dao.PurchaseInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.entity.PurchaseInfo;
import com.jwz.salesteam.service.GoodListService;
import com.jwz.salesteam.service.PurchaseInfoService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/23 11:04
 * @description：采购单
 * @modified By：
 * @version:
 */
@Service
public class PurchaseInfoServiceImpl implements PurchaseInfoService {

    @Autowired
    private PurchaseInfoMapper purchaseInfoMapper;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private GoodsListMapper goodsListMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderListVO> getPersonMerchandiser(String emp_id) {
        List<OrderListVO> orderListVOList = new ArrayList<>();

        List<String> ordersIdList = orderInfoMapper.findFinishOrdersIdList(); //找到所有的id
        for(String orderId : ordersIdList){
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setOrderId(orderId);
            List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.selectByEmpId(emp_id), PurchaseInfoVO.class);
            for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
                String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
                Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
                purchaseInfoVO.setGoodsName(goodsName);
                purchaseInfoVO.setGoodsNum(goodsNum);
            }
            orderListVO.setPurchaseInfoVO(purchaseInfoList);
            orderListVOList.add(orderListVO);
        }
        return orderListVOList;
    }

    @Override
    public List<OrderListVO> getPersonAccount(String accountEmpId) {

        List<OrderListVO> orderListVOList = new ArrayList<>();

        List<String> ordersIdList = orderInfoMapper.findFinishOrdersIdList(); //找到所有的id
        for(String orderId : ordersIdList){
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setOrderId(orderId);
            List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.selectByAccountEmpId(accountEmpId), PurchaseInfoVO.class);
            for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
                String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
                Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
                purchaseInfoVO.setGoodsName(goodsName);
                purchaseInfoVO.setGoodsNum(goodsNum);
            }
            orderListVO.setPurchaseInfoVO(purchaseInfoList);
            orderListVOList.add(orderListVO);
        }
        return orderListVOList;
    }

    @Override
    public String savePurchaseInfo(PurchaseInfo purchaseInfo) {
        String purchase_id =  NumberUtil.genPurchaseNo();
        purchaseInfo.setPurchaseId(purchase_id);

        if (purchaseInfoMapper.insertSelective(purchaseInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }

    @Override
    public List<OrderListVO> getPurchaseInfoList() {
//        List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.findPurchaseInfoList(), PurchaseInfoVO.class);
        List<OrderListVO> orderListVOList = new ArrayList<>();

        List<String> ordersIdList = orderInfoMapper.findOrdersIdList(); //找到所有的id
        for(String orderId : ordersIdList){
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setOrderId(orderId);
            List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.findPurchaseInfoByOrderId(orderId,0,null), PurchaseInfoVO.class);
            for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
                String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
                Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
                purchaseInfoVO.setGoodsName(goodsName);
                purchaseInfoVO.setGoodsNum(goodsNum);
            }
            orderListVO.setPurchaseInfoVO(purchaseInfoList);
            orderListVOList.add(orderListVO);
        }
        return orderListVOList;

    }

    @Override
    public String updatePurchaseState(String purchase_id, int status, HttpSession httpSession) {
        if(httpSession.getAttribute("财务人员") != null){
            EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("财务人员");
            purchaseInfoMapper.updateAccountEmpId(purchase_id,empInfo.getEmpId());

        }
        PurchaseInfo temp = purchaseInfoMapper.selectByPurchaseId(purchase_id);
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        Integer orderStatus = orderInfoMapper.findOrderStatusByOrderId(temp.getOrderId());

        if((orderStatus < status) &&status == 3){ // 审批完成---采购中
            orderInfoMapper.updateOrdersState(temp.getOrderId(),2);
        }
        if((orderStatus < status) && status == 4){ // 已发货--配送中
            orderInfoMapper.updateOrdersState(temp.getOrderId(),3);
        }
        if ((orderStatus < status) && status == 5){ //已收货---已到货
            purchaseInfoMapper.updateFinishTime(purchase_id,new Date());
            List<PurchaseInfo> purchaseInfoList = purchaseInfoMapper.findPurchaseInfoByOrderId(temp.getOrderId(),0,null);
            if(purchaseInfoList.size() == 0){
                orderInfoMapper.updateOrdersState(temp.getOrderId(),4);
            }
        }
        if (purchaseInfoMapper.updatePurchaseState(purchase_id,status) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updatePurchaseInfo(PurchaseInfo purchaseInfo) {
        Integer orderStatus = orderInfoMapper.findOrderStatusByOrderId(purchaseInfo.getOrderId());
        if(orderStatus <= purchaseInfo.getStatus()){
            orderInfoMapper.updateOrdersState(purchaseInfo.getOrderId(),1);
        }
        if (purchaseInfoMapper.updateByPrimaryKey(purchaseInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public List<OrderListVO> getPurchaseInfoReqList() {
        List<OrderListVO> orderListVOList = new ArrayList<>();

        List<String> ordersIdList = orderInfoMapper.findOrdersIdList(); //找到所有的id
        //找到状态为2的订购表信息
        for(String orderId : ordersIdList){
            OrderListVO orderListVO = new OrderListVO();
            orderListVO.setOrderId(orderId);
            List<PurchaseInfo> tempList = purchaseInfoMapper.findPurchaseInfoByOrderId(orderId,0,2);
            if(tempList.size()>0){
            List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(tempList, PurchaseInfoVO.class);
            for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
                String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
                Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
                Integer goodsCostPrice = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsCostPrice();
                purchaseInfoVO.setGoodsName(goodsName);
                purchaseInfoVO.setGoodsNum(goodsNum);
                purchaseInfoVO.setGoodsCostPrice(goodsCostPrice);
            }
            orderListVO.setPurchaseInfoVO(purchaseInfoList);
            orderListVOList.add(orderListVO);
            }
        }
        return orderListVOList;
    }


}
