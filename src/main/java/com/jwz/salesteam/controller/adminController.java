package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.NumberUtil;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.nio.Buffer;
import java.util.Date;
import java.util.Objects;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/16 18:56
 * @description：管理员业务处理
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/admin")
@Api(value = "adminController|一个用来测试管理员注解的控制器")
public class adminController {

    @Autowired
    private EmpInfoService empInfoService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 添加职员信息
     * @param empInfo
     * @return
     */
    @RequestMapping(value = "/emp/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加职员信息")
    public Result saveEmpInfo(@RequestBody EmpInfo empInfo) {
        if (StringUtils.isEmpty(empInfo.getEmpName())
                || StringUtils.isEmpty(empInfo.getEmpTel())
                || Objects.isNull(empInfo.getEmpSex())
                || Objects.isNull(empInfo.getEmpType())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        //empInfo.setCreateTime(new Date());
       // empInfo.setUpdateTime(new Date());
        String result = empInfoService.saveEmpInfo(empInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改职员信息
     * @param empInfo
     * @return
     */
    @RequestMapping(value = "/emp/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改职员信息")
    public Result updateEmpInfo(@RequestBody EmpInfo empInfo) {
        if (StringUtils.isEmpty(empInfo.getEmpId())
                || StringUtils.isEmpty(empInfo.getEmpName())
                || StringUtils.isEmpty(empInfo.getEmpTel())
                || StringUtils.isEmpty(empInfo.getEmpPwd())
                || Objects.isNull(empInfo.getEmpSex())
                || Objects.isNull(empInfo.getEmpType())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = empInfoService.updateEmpInfo(empInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 删除职员信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除职员信息")
    public Result deleteEmpInfo(@PathVariable("id") Integer id) {

        if (empInfoService.delEmpInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 查看职员列表
     * @return
     */
    @RequestMapping(value = "/emp/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查看职员信息列表")
    public Result getEmpList() {
        return ResultGenerator.genSuccessResult(empInfoService.getEmpList());
    }

    /**
     * 查看职员（搜索)
     * @param emp_name
     * @return
     */
    @RequestMapping(value = "/emp/findByName/{emp_name}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查询职员信息")
    public Result empInfoFindByName(@PathVariable("emp_name") String emp_name) {
        return ResultGenerator.genSuccessResult(empInfoService.findByEmpName(emp_name));
    }

    /**
     * 添加商品信息
     * @param goodsInfo
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/goods/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加商品信息")
    public Result saveGoodsInfo(GoodsInfo goodsInfo) throws IOException {
        if (StringUtils.isEmpty(goodsInfo.getGoodsName())
                || StringUtils.isEmpty(goodsInfo.getGoodsName())
                || Objects.isNull(goodsInfo.getGoodsSellingPrice())
                || Objects.isNull(goodsInfo.getGoodsCostPrice())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        //empInfo.setCreateTime(new Date());
        // empInfo.setUpdateTime(new Date());
        String result = goodsInfoService.saveGoodsInfo(goodsInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     *
     * 删除商品信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/goods/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除商品信息")
    public Result deleteGoodsInfo(@PathVariable("id") Integer id) {

        if (goodsInfoService.delGoodsInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


    /**
     * 修改商品信息
     * @param goodsInfo
     * @return
     */
    @RequestMapping(value = "/goods/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改商品信息")
    public Result updateGoodsInfo(GoodsInfo goodsInfo) {
        if (StringUtils.isEmpty(goodsInfo.getGoodsName())
                || StringUtils.isEmpty(goodsInfo.getGoodsName())
                || Objects.isNull(goodsInfo.getGoodsSellingPrice())
                || Objects.isNull(goodsInfo.getGoodsCostPrice())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        String result = goodsInfoService.updateGoodsInfo(goodsInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 查看所有商品
     * @return
     */
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查看商品列表")
    public Result getGoodsList() {
        return ResultGenerator.genSuccessResult(goodsInfoService.getGoodsInfoList());
    }

    /**
     * 查看商品（搜索)
     * @param goods_name
     * @return
     */
    @RequestMapping(value = "/goods/findByName/{goods_name}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查询商品信息")
    public Result goodsInfoFindByName(@PathVariable("goods_name") String goods_name) {
        return ResultGenerator.genSuccessResult(goodsInfoService.findByGoodsName(goods_name));
    }


    /**
     * 查看所有客户
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查看商品列表")
    public Result getUserList() {
        return ResultGenerator.genSuccessResult(userInfoService.getUserInfoList());
    }

}
