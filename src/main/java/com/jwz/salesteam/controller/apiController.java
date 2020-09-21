package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/17 16:14
 * @description：api接口
 * @modified By：
 * @version: 1.0
 */
@RestController
@RequestMapping("/api")
@Api(value = "apiController|一个用来api接口的控制器")
public class apiController {

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="登录")
    public String login(String emp_id, String emp_pwd, String emp_type, HttpSession httpSession) {
            return "hello";
//        String result = empInfoService.updateEmpInfo(empInfo);
//        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
//            return ResultGenerator.genSuccessResult();
//        } else {
//            return ResultGenerator.genFailResult(result);
//        }
    }
}
