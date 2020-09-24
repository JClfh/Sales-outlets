package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.entity.PurchaseInfo;
import com.jwz.salesteam.service.PurchaseInfoService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/purchase")
public class purchaseController {
    @Autowired
    private PurchaseInfoService purchaseInfoService;

    /**
     * 创建采购单
     * @param purchaseInfo
     * @return
     */
    @RequestMapping(value = "/updatePurchase", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePurchaseInfo(@RequestBody PurchaseInfo purchaseInfo, HttpSession httpSession) {
        if (StringUtils.isEmpty(purchaseInfo.getGoodsId()) || Objects.isNull(purchaseInfo.getGoodsPrice())) {
                return ResultGenerator.genFailResult("参数异常！");
        }
        EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("跟单员");
        purchaseInfo.setEmpId(empInfo.getEmpId());
        String result = purchaseInfoService.updatePurchaseInfo(purchaseInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 跟单员查看订单列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result getPurchaseInfoList() {
        return ResultGenerator.genSuccessResult(purchaseInfoService.getPurchaseInfoList());
    }

    /**
     * 财务人员查看待审核订单
     * @return
     */
    @RequestMapping(value = "/reqlist", method = RequestMethod.GET)
    @ResponseBody
    public Result getPurchaseInfoReqList() {
        return ResultGenerator.genSuccessResult(purchaseInfoService.getPurchaseInfoReqList());
    }
    /**
     * 财务审核订单（修改状态）,可用于跟单员
     * @param purchase_id,status
     * @return
     */

    @RequestMapping(value = "/updatePurchaseStatus", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePurchaseState(@Param("purchase_id") String purchase_id, @Param("status") int status) {
        String result = purchaseInfoService.updatePurchaseState(purchase_id,status);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }


}
