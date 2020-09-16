package com.jwz.salesteam.controller;

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

import java.util.Objects;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/16 15:48
 * @description：测试类
 * @modified By：
 * @version: 1.0
 */
@RestController

@Api(value = "hello|一个用来测试swagger注解的控制器")
public class hello {

    @Autowired
    private EmpInfoService empInfoService;

    @GetMapping("/hello")
    @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType="query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String hello(){
        return "hello";
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody EmpInfo empInfo) {
        if (Objects.isNull(empInfo.getEmpName())
                || StringUtils.isEmpty(empInfo.getEmpTel())
                || Objects.isNull(empInfo.getEmpSex())
                || Objects.isNull(empInfo.getEmpType())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String emp_id =  NumberUtil.genEmpId();
        empInfo.setEmpId(emp_id);
        empInfo.setEmpPwd(emp_id);
        String result = empInfoService.saveEmpInfo(empInfo);
        return ResultGenerator.genSuccessResult(result);
//        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult(result);
//        }
    }
}
