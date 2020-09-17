package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.util.NumberUtil;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    /**
     *
     * 添加职员信息
     *
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
        String emp_id =  NumberUtil.genEmpId();
        EmpInfo temp = empInfoService.selectByEmpId(emp_id);
        //防止随机ID重复
        while (temp != null){
            emp_id =  NumberUtil.genEmpId();
            temp = empInfoService.selectByEmpId(emp_id);
        }
        empInfo.setEmpId(emp_id);
        empInfo.setEmpPwd(emp_id);
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
     *
     * 修改职员信息
     *
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
     *
     * 删除职员
     *
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
     *
     * 查看职员列表
     *
     */
    @RequestMapping(value = "/emp/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查看职员信息列表")
    public Result getEmpList() {
        return ResultGenerator.genSuccessResult(empInfoService.getEmpList());
    }

    /**
     *
     * 查看职员（搜索)
     *
     */
    @RequestMapping(value = "/emp/findByName/{emp_name}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查询职员信息")
    public Result empInfoFindByName(@PathVariable("emp_name") String emp_name) {
        return ResultGenerator.genSuccessResult(empInfoService.findByEmpName(emp_name));
    }

    /**
     *
     * 添加商品
     *
     */
    @RequestMapping(value = "/goods/save", method = RequestMethod.POST)
    @ResponseBody
    public Result empInfoFindByName( GoodsInfo goodsInfo) {
        System.out.println("sb");
        System.out.println(goodsInfo.toString());
//        String base64Data = pro_img.replace(/^data:image\/\w+;base64,/, "");
//        String dataBuffer = new Buffer(base64Data, 'base64');
        return ResultGenerator.genSuccessResult();
    }

    /**
     *
     * 删除商品
     *
     */

    /**
     *
     *修改商品
     *
     */

}
