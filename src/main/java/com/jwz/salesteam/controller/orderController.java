package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.GoodsInfoVO;
import com.jwz.salesteam.controller.common.ShoppingCartItemVO;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.OrderInfo;
import com.jwz.salesteam.entity.UserInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/orders")
public class orderController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 添加订单信息
     * @param shoppingCartItemVO
     * @return
     */
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrderInfo(@RequestBody ShoppingCartItemVO shoppingCartItemVO,HttpSession httpSession) {
       if (StringUtils.isEmpty(shoppingCartItemVO.getOrderInfo().getTakeInPrice()) || Objects.isNull(shoppingCartItemVO.getOrderInfo().getModeOfDistibution())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = orderInfoService.saveOrderInfo(shoppingCartItemVO,httpSession);
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
    public Result updateOrdersState(@Param("order_id") String order_id, @RequestParam("status") int status) {
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
     * @param
     * @return
     */
    @RequestMapping(value = "/saleList", method = RequestMethod.GET)
    @ResponseBody
    public Result getGoodsInfo(HttpSession httpSession) {
        if(httpSession.getAttribute("销售员") == null){
            return ResultGenerator.genFailResult("未登录");
        }
        EmpInfo temp = (EmpInfo)httpSession.getAttribute("销售员");
        return ResultGenerator.genSuccessResult(orderInfoService.getOrdersInfoList2(temp.getEmpId()));
    }


    @RequestMapping(value = "/findByOrderId/{order_id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findByOrderDetail(@PathVariable("order_id") String order_id) {
        return  ResultGenerator.genSuccessResult(orderInfoService.findByOrderDetail(order_id));
    }
}
