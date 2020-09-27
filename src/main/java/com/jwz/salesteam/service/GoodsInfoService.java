package com.jwz.salesteam.service;

import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;

import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/18 15:32
 * @description：
 * @modified By：Liang Jiangle
 * @version:
 */
public interface GoodsInfoService {

    /**
     *添加职员
     */
    String saveGoodsInfo(GoodsInfo goodsInfo);

    List<GoodsInfo> getGoodsInfoList();

    int delGoodsInfo(Integer id);

    String updateGoodsInfo(GoodsInfo goodsInfo);

    List<GoodsInfo> findByGoodsName(String goods_name);

    List<GoodsInfo> getGoodsInfoList2();

    GoodsInfo getGoodsInfo(String  goodsId);
}
