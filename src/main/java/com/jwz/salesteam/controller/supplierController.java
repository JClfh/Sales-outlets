package com.jwz.salesteam.controller;

import com.jwz.salesteam.entity.SupplierInfo;
import com.jwz.salesteam.service.SupplierInfoService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/24 13:25
 * @description：供应商
 * @modified By：
 * @version:
 */

@RestController
@RequestMapping("/supplier")
public class supplierController {
    @Autowired
    private SupplierInfoService supplierInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result getPurchaseInfoList() {
        return ResultGenerator.genSuccessResult(supplierInfoService.getSupplierInfoList());
    }
}
