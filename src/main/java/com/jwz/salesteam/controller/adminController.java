package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.entity.SupplierInfo;
import com.jwz.salesteam.entity.UserInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.service.SupplierInfoService;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.NumberUtil;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;
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
@Controller
@RequestMapping("/admin")
@Api(value = "adminController|一个用来测试管理员注解的控制器")
public class adminController {

    @Autowired
    private EmpInfoService empInfoService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SupplierInfoService supplierInfoService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="登录")
    public Result login(@RequestParam("emp_id") String emp_id,@RequestParam("emp_pwd") String emp_pwd, HttpSession httpSession) {

        if (StringUtils.isEmpty(emp_id)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.EMP_ID_NULL.getResult());
        }
        if (StringUtils.isEmpty(emp_pwd)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.EMP_PWD_NULL.getResult());
        }
        String loginResult = empInfoService.Adminlogin(emp_id, emp_pwd,httpSession);
        //登录成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
            return ResultGenerator.genSuccessResult();
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    /**
     * 退出
     * @param
     * @return
     */
    @GetMapping("/logout")
    @ApiOperation(value="退出")
    public String logout( HttpSession httpSession) {
        httpSession.removeAttribute("admin");
        return "redirect:http://localhost:9091/admin/login";
    }

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
    public Result saveGoodsInfo(GoodsInfo goodsInfo)  {
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
     * 查看所有商品(管理员端）
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
    @ApiOperation(value="查看所有客户")
    public Result getUserList() {
        return ResultGenerator.genSuccessResult(userInfoService.getUserInfoList());
    }

    /**
     * 修改客户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改客户信息")
    public Result updateUserInfo(@RequestBody UserInfo userInfo) {
        if (StringUtils.isEmpty(userInfo.getUserName())
                || StringUtils.isEmpty(userInfo.getUserTel())
                || Objects.isNull(userInfo.getUserSex())
                || Objects.isNull(userInfo.getUserVip())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        String result = userInfoService.updateUserInfo(userInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     *
     * 删除客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除客户信息")
    public Result deleteUserInfo(@PathVariable("id") Integer id) {

        if (userInfoService.delUserInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 查看客户（搜索）
     * @return
     */
    @RequestMapping(value = "/user/findByName/{user_name}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查看客户（搜索）")
    public Result userInfoFindByName(@PathVariable("user_name") String user_name) {
        return ResultGenerator.genSuccessResult(userInfoService.findByUserName(user_name));
    }


    /**
     * 添加供应商信息
     * @param supplierInfo
     * @return
     */
    @RequestMapping(value = "/supplier/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加供应商信息")
    public Result saveSupplierInfo(@RequestBody SupplierInfo supplierInfo) {
        if (StringUtils.isEmpty(supplierInfo.getSupplierName())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        String result = supplierInfoService.saveSupplierInfo(supplierInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改供应商信息
     * @param supplierInfo
     * @return
     */
    @RequestMapping(value = "/supplier/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改供应商信息")
    public Result updateSupplierInfo(@RequestBody  SupplierInfo supplierInfo) {
        if (StringUtils.isEmpty(supplierInfo.getSupplierName())
                || StringUtils.isEmpty(supplierInfo.getSupplierId())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = supplierInfoService.updateSupplierInfo(supplierInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 删除供应商信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/supplier/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除供应商信息")
    public Result deleteSupplier(@PathVariable("id") Integer id) {

        if (supplierInfoService.delSupplierInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 查询供应商信息列表
     * @return
     */
    @RequestMapping(value = "/supplier/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查询供应商信息列表")
    public Result getSupplierList() {
        return ResultGenerator.genSuccessResult(supplierInfoService.getSupplierInfoList2());
    }

    /**
     * 查询供应商信息（搜索)
     * @param supplier_name
     * @return
     */
    @RequestMapping(value = "/supplier/findByName/{supplier_name}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查询供应商信息")
    public Result supplierInfoFindByName(@PathVariable("supplier_name") String supplier_name) {
        return ResultGenerator.genSuccessResult(supplierInfoService.findBySupplierName(supplier_name));
    }

    /**
     * 修改职员信息（锁）
     * @param id,isLock
     * @return
     */
    @RequestMapping(value = "/emp/changelock", method = RequestMethod.POST)
    @ResponseBody

    public Result changelock(@Param("id") Integer id, @Param("isLock") Integer isLock) {

        String result = empInfoService.changelock(id,isLock);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改职员信息（锁）
     * @param id,isLock
     * @return
     */
    @RequestMapping(value = "/supplier/changelock", method = RequestMethod.POST)
    @ResponseBody

    public Result changeSupplierlock(@Param("id") Integer id, @Param("isDel") Integer isDel) {

        String result = supplierInfoService.changeSupplierlock(id,isDel);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
}
