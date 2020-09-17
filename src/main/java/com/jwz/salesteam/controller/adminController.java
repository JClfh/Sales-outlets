package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.EmpInfo;
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
     * 添加职员信息
     */
    @RequestMapping(value = "/emp/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加职员信息")
    public Result save(@RequestBody EmpInfo empInfo) {
        if (StringUtils.isEmpty(empInfo.getEmpName())
                || StringUtils.isEmpty(empInfo.getEmpTel())
                || Objects.isNull(empInfo.getEmpSex())
                || Objects.isNull(empInfo.getEmpType())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String emp_id =  NumberUtil.genEmpId();
        empInfo.setEmpId(emp_id);
        empInfo.setEmpPwd(emp_id);
        empInfo.setCreateTime(new Date());
        empInfo.setUpdateTime(new Date());
        String result = empInfoService.saveEmpInfo(empInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 修改职员信息
     */
    @RequestMapping(value = "/emp/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改职员信息")
    public Result update(@RequestBody EmpInfo empInfo) {
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
     * 删除职员
     */
    @RequestMapping(value = "/emp/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除职员信息")
    public Result del(@PathVariable("id") Integer id) {

        if (empInfoService.delEmpInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 查看职员列表
     */
    @RequestMapping(value = "/emp/list", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查看职员信息列表")
    public Result list() {
        return ResultGenerator.genSuccessResult(empInfoService.getEmpList());
    }

//    /**
//     * 查看职员（搜索)
//     */
//    @RequestMapping(value = "/emp/del/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value="删除职员信息")
//    public Result del(@PathVariable("id") Integer id) {
//
//        if (empInfoService.delEmpInfo(id)>0) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult("删除失败");
//        }
//    }

}
