package com.jwz.salesteam.controller;

import com.jwz.salesteam.service.GoodsInfoService;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods")
@Api(value = "goodsController|一个用来商品信息接口的控制器")
public class goodsController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * 商品列表展示
     * @return
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="商品列表展示")
    public Result getGoodsInfoList() {
        return ResultGenerator.genSuccessResult(goodsInfoService.getGoodsInfoList2());
    }

    /**
     * 商品详情展示
     * @param id
     * @return
     */
    @RequestMapping(value = "/info/{goodsId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="商品详情展示")
    public Result getGoodsInfo(@PathVariable("goodsId") String goodsId) {

        if (goodsId != null) {
            return ResultGenerator.genSuccessResult(goodsInfoService.getGoodsInfo(goodsId));
        }
        return ResultGenerator.genFailResult("空");

    }
}
