package com.jwz.salesteam.service.impl;

import com.jwz.salesteam.common.FileUpload;
import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.dao.GoodsInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/18 15:32
 * @description：商品服务
 * @modified By：
 * @version: 1.0
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public String saveGoodsInfo(GoodsInfo goodsInfo) {
        GoodsInfo temp = goodsInfoMapper.selectByName(goodsInfo.getGoodsName());
        if (temp != null) {

            return ServiceResultEnum.SAME_GOODSINFO_EXIST.getResult();
//            return "该职员已经存在";
        }
        String goods_id =  NumberUtil.getGoodsId();
        goodsInfo.setGoodsId(goods_id);
        String fileUpload = FileUpload.fileUpload(goodsInfo.getGoodsCoverImg());
        if(fileUpload.equals(ServiceResultEnum.UPLOAD_ERROR.getResult())){
            return ServiceResultEnum.UPLOAD_ERROR.getResult();
        }
        goodsInfo.setGoodsCoverImg(fileUpload);
        if (goodsInfoMapper.insertSelective(goodsInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
//            return "添加成功";
        }
        return ServiceResultEnum.DB_ERROR.getResult();
//        return "出现未知错误";
    }

    @Override
    public List<GoodsInfo> getGoodsInfoList() {
        return goodsInfoMapper.findGoodsInfoList();
    }

    @Override
    public int delGoodsInfo(Integer id) {
        GoodsInfo temp = goodsInfoMapper.selectByPrimaryKey(id);
        if(temp == null){
            return 0;
        }

        return goodsInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String updateGoodsInfo(GoodsInfo goodsInfo) {
        GoodsInfo temp = goodsInfoMapper.selectByPrimaryKey(goodsInfo.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsInfo temp2 = goodsInfoMapper.selectByNameAndId(goodsInfo.getGoodsName(),goodsInfo.getId());
        if (temp2 != null) {
            //同商品名且不同id 不能继续修改
            return ServiceResultEnum.SAME_GOODSINFO_EXIST.getResult();
        }
        if(!goodsInfo.getGoodsCoverImg().subSequence(0, 4).equals("http")){
            String fileUpload = FileUpload.fileUpload(goodsInfo.getGoodsCoverImg());
            if(fileUpload.equals(ServiceResultEnum.UPLOAD_ERROR.getResult())){
                return ServiceResultEnum.UPLOAD_ERROR.getResult();
            }
            goodsInfo.setGoodsCoverImg(fileUpload);
        }
        if (goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public List<GoodsInfo> findByGoodsName(String goods_name) {
        return goodsInfoMapper.findByGoodsName(goods_name);
    }
}
