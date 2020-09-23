package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class orderController {

    @Autowired
    private OrderInfoService orderInfoService;
    /**
     * 添加订单信息
     * @param orderInfo
     * @return
     */

    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrderInfo(@RequestBody OrderInfo orderInfo) {
        if (StringUtils.isEmpty(orderInfo.getTakeInPrice()) || Objects.isNull(orderInfo.getModeOfDistibution())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        String result = orderInfoService.saveOrderInfo(orderInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 销售员修改订单信息（修改订单状态）
     * 跟单员采购（修改订单状态）
     * @param order_id,status
     * @return
     */

    @RequestMapping(value = "/ordersState", method = RequestMethod.POST)
    @ResponseBody
    public Result updateOrdersState(@RequestParam("order_id") String order_id,@RequestParam("status") int status) {
        String result = orderInfoService.updateOrdersState(order_id,status);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 跟单员查看订单
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result getOrdersInfoList() {
        return ResultGenerator.genSuccessResult(orderInfoService.getOrdersInfoList());
    }

    /**
     * 销售员查看订单
     * @param emp_id
     * @return
     */
    @RequestMapping(value = "/findById/{emp_id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getGoodsInfo(@PathVariable("emp_id") String emp_id) {
        return ResultGenerator.genSuccessResult(orderInfoService.getOrdersInfoList2(emp_id));
    }

}
