package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.controller.common.PurchaseInfoVO;
import com.jwz.salesteam.controller.common.UserInfoVO;
import com.jwz.salesteam.dao.GoodsInfoMapper;
import com.jwz.salesteam.dao.GoodsListMapper;
import com.jwz.salesteam.dao.PurchaseInfoMapper;
import com.jwz.salesteam.entity.PurchaseInfo;
import com.jwz.salesteam.service.GoodListService;
import com.jwz.salesteam.service.PurchaseInfoService;
import com.jwz.salesteam.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<PurchaseInfoVO> getPersonMerchandiser(String emp_id) {
        List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.selectByEmpId(emp_id), PurchaseInfoVO.class);
        for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
            String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
            Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
            purchaseInfoVO.setGoodsName(goodsName);
            purchaseInfoVO.setGoodsNum(goodsNum);
        }
        return purchaseInfoList;
    }

    @Override
    public List<PurchaseInfoVO> getPersonAccount(String accountEmpId) {

        List<PurchaseInfoVO> purchaseInfoList = BeanUtil.copyList(purchaseInfoMapper.selectByAccountEmpId(accountEmpId), PurchaseInfoVO.class);
        for(PurchaseInfoVO purchaseInfoVO:purchaseInfoList){
            String goodsName = goodsInfoMapper.selectByGoodsName(purchaseInfoVO.getGoodsId()).getGoodsName();
            Integer goodsNum = goodsListMapper.selectByGoodsIdAndOrderId(purchaseInfoVO.getGoodsId(),purchaseInfoVO.getOrderId());
            purchaseInfoVO.setGoodsName(goodsName);
            purchaseInfoVO.setGoodsNum(goodsNum);
        }
        return purchaseInfoList;
    }


}
