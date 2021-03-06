package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.*;
import com.jwz.salesteam.dao.*;
import com.jwz.salesteam.entity.*;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.service.OrderListService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.NumberUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.util.*;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private GoodsListMapper goodsListMapper;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private EmpInfoMapper empInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PurchaseInfoMapper purchaseInfoMapper;
    @Override
    public String saveOrderInfo(ShoppingCartItemVO shoppingCartItemVO, HttpSession httpSession) {
        EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("销售员");
        if(empInfo == null){
            return "未登录";
        }
        UserInfo userInfo = shoppingCartItemVO.getUserInfo();
        String userId = "";
        //更新用户信息
        if(userInfo.getId() == null){
            userInfo.setFirstSaleman(empInfo.getId());
            userInfo.setLastSaleman(empInfo.getId());
            userInfoMapper.insert(userInfo);
            userId = String.valueOf(userInfoMapper.selectByTel(userInfo.getUserTel()).getId());
        }else{
            userInfo.setLastSaleman(empInfo.getId());
            userInfo.setUpdateTime(new Date());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            userId = String.valueOf(userInfoMapper.selectByTel(userInfo.getUserTel()).getId());
        }

        //更新订单信息
        OrderInfo orderInfo = shoppingCartItemVO.getOrderInfo();
        String order_id =  NumberUtil.genOrderNo();
        orderInfo.setOrderId(order_id);
        orderInfo.setEmpId(empInfo.getEmpId());
        orderInfo.setUserId(userId);
        if (orderInfoMapper.insertSelective(orderInfo) > 0) {
            //创建商品列表和采购单
            for(GoodsInfoVO goodsInfoVO:shoppingCartItemVO.getGoodsInfoVOList()){
                GoodsList goodsList = new GoodsList();
                BeanUtil.copyProperties(goodsInfoVO,goodsList);
                goodsList.setSupplierId("0");
                goodsList.setOrderId(order_id);
                goodsList.setId(null);
                goodsListMapper.insertSelective(goodsList);
                Integer goodsPrice = goodsInfoMapper.selectByGoodsId(goodsList.getGoodsId()).getGoodsCostPrice();
                //采购单
                PurchaseInfo purchaseInfo = new PurchaseInfo("-1","-1","-1",goodsPrice,order_id,goodsList.getGoodsId(),
                        "-1","-1",0,new Date(),null,0 );
                purchaseInfoMapper.insertSelective(purchaseInfo);
            }
            httpSession.removeAttribute("shopping-cart");
            return ServiceResultEnum.SUCCESS.getResult();

        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }

    @Override
    public String updateOrdersState(String order_id, int status) {
        if (status == 5){
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
    public List<UserOrderInfoVO> getOrdersInfoList2(String emp_id) {
        List<UserOrderInfoVO> orderInfoVOS  = BeanUtil.copyList(orderInfoMapper.findOrdersInfoList2(emp_id),UserOrderInfoVO.class); //找到所有的订单id
        for(UserOrderInfoVO orderInfoVO :orderInfoVOS){
            //去商品列表查询商品id
            List<GoodsList> goodsLists = goodsListMapper.selectByGoodsOrderId(orderInfoVO.getOrderId());
            String goodsName ="";
            Integer goodsCostPrice = 0;
            for(GoodsList goodsList: goodsLists){
                GoodsInfo goodsInfo = goodsInfoMapper.selectByGoodsId(goodsList.getGoodsId());
                goodsName += "   "+goodsInfo.getGoodsName() +"  X  " + goodsList.getGoodsNum()+"\n";
                goodsCostPrice += goodsInfo.getGoodsCostPrice();
            }
            orderInfoVO.setGoodsAllPrice(goodsCostPrice);
            orderInfoVO.setGoodsName(goodsName);
        }
        return orderInfoVOS;
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
    public OrderDetailInfoVO findByOrderDetail(String order_id) {
        //通过id查询goodlist
        List<GoodsList> goodsLists = goodsListMapper.selectByGoodsOrderId(order_id);
        List<GoodsInfoVO> goodsInfoVOS = new ArrayList<>();
        Integer allPrice = 0;
        for(GoodsList goodsList: goodsLists){

            GoodsInfo goodsInfo = goodsInfoMapper.selectByGoodsId(goodsList.getGoodsId());
            PurchaseInfo purchaseInfo = purchaseInfoMapper.findByOrderIdAndGoodsId(order_id,goodsList.getGoodsId());
            allPrice += (goodsInfo.getGoodsSellingPrice() * goodsList.getGoodsNum());
            GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
            BeanUtil.copyProperties(goodsInfo,goodsInfoVO);
            goodsInfoVO.setGoodsNum(goodsList.getGoodsNum());
            goodsInfoVO.setGoodsPrice(goodsList.getGoodsPrice());
            goodsInfoVO.setStatus(purchaseInfo.getStatus());
            goodsInfoVOS.add(goodsInfoVO);
        }
        OrderInfo orderInfo = orderInfoMapper.selectByOrderId(order_id);

        OrderDetailInfoVO orderDetailInfoVO = new OrderDetailInfoVO();
        orderDetailInfoVO.setGoodsInfoVOList(goodsInfoVOS);
        orderDetailInfoVO.setOrderId(order_id);
        orderDetailInfoVO.setAllPrice(allPrice);
        orderDetailInfoVO.setTakeInPrice(orderInfo.getTakeInPrice());
        orderDetailInfoVO.setEmpName(empInfoMapper.selectByEmpId(orderInfo.getEmpId()).getEmpName());
        orderDetailInfoVO.setUserInfo(userInfoMapper.selectByPrimaryKey(Integer.valueOf(orderInfo.getUserId())));

        return orderDetailInfoVO;
    }


}


