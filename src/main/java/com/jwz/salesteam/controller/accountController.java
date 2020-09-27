package com.jwz.salesteam.controller;

import com.jwz.salesteam.service.AccountService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/25 15:39
 * @description：利润控制器
 * @modified By：
 * @version:
 */
@RequestMapping("/account")
@RestController
public class accountController {
    @Autowired
    private AccountService accountService;

    /**
     *
     *查看业绩统计
     * @return
     */
    @GetMapping("/exploit")
    @ResponseBody
    @ApiOperation(value="查看业绩统计")
    public Result personAccount(){
        return  ResultGenerator.genSuccessResult(accountService.getAllCount());
    }

    /**
     * 查询个人业绩
     * @param search
     * @return
     */
    @GetMapping("/searchResults/{search}")
    @ResponseBody
    @ApiOperation(value="查询个人业绩")
    public Result searchResults(@PathVariable("search") String search){
        return  ResultGenerator.genSuccessResult(accountService.searchByEmpdIdOrEmpName(search));
    }


    @GetMapping("/earnAccount")
    @ResponseBody
    @ApiOperation(value="查看七天利润统计")
    public Result earnSevenAccount(){
        return  ResultGenerator.genSuccessResult(accountService.earnAccount());
    }

    @GetMapping("/earnMonthAccount")
    @ResponseBody
    @ApiOperation(value="查看业绩统计")
    public Result earnMonthAccount() {
        return  ResultGenerator.genSuccessResult(accountService.earnMonthAccount());
    }
}
