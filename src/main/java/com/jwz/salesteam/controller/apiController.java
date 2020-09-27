package com.jwz.salesteam.controller;

import com.jwz.salesteam.common.ServiceResultEnum;
import com.jwz.salesteam.controller.common.EmpInfoVO;
import com.jwz.salesteam.controller.common.GoodsInfoVO;
import com.jwz.salesteam.controller.common.ShoppingCartList;
import com.jwz.salesteam.dao.GoodsInfoMapper;
import com.jwz.salesteam.entity.EmpInfo;
import com.jwz.salesteam.entity.GoodsInfo;
import com.jwz.salesteam.entity.UserInfo;
import com.jwz.salesteam.service.EmpInfoService;
import com.jwz.salesteam.service.OrderInfoService;
import com.jwz.salesteam.service.PurchaseInfoService;
import com.jwz.salesteam.service.UserInfoService;
import com.jwz.salesteam.util.BeanUtil;
import com.jwz.salesteam.util.Result;
import com.jwz.salesteam.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/17 16:14
 * @description：api接口
 * @modified By：
 * @version: 1.0
 */
@Controller
@RequestMapping("/api")
@Api(value = "apiController|一个用来api接口的控制器")
public class apiController {

    @Autowired
    private EmpInfoService empInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private PurchaseInfoService purchaseInfoService;

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    /**
     * 登录
     * @param emp_id
     * @param emp_pwd
     * @param emp_type
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/emp/login", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="登录")
    public Result login(@RequestParam("emp_id") String emp_id,@RequestParam("emp_pwd") String emp_pwd,@RequestParam("emp_type") Integer emp_type,HttpSession httpSession) {
        System.out.println(emp_id+"----"+emp_pwd+"---"+emp_type+"----");
        if (StringUtils.isEmpty(emp_id)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.EMP_ID_NULL.getResult());
        }
        if (StringUtils.isEmpty(emp_pwd)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.EMP_PWD_NULL.getResult());
        }
        if (StringUtils.isEmpty(emp_type)) {
            return ResultGenerator.genFailResult(ServiceResultEnum.EMP_TYPE_NULL.getResult());
        }

        String loginResult = empInfoService.login(emp_id, emp_pwd, emp_type,httpSession);
        //登录成功
        if (ServiceResultEnum.SUCCESS.getResult().equals(loginResult)) {
            return ResultGenerator.genSuccessResult(emp_type);
        }
        //登录失败
        return ResultGenerator.genFailResult(loginResult);
    }

    /**
     * 退出
     * @param httpSession
     * @return
     */
    @GetMapping("/emp/logout")
    @ApiOperation(value="退出")
    public String logout(HttpSession httpSession) {
        if(httpSession.getAttribute("销售员") != null){
            httpSession.removeAttribute("销售员");
        }else if(httpSession.getAttribute("跟单员") != null){
            httpSession.removeAttribute("跟单员");
        }else if(httpSession.getAttribute("财务人员") != null){
            httpSession.removeAttribute("财务人员");
        }
        return "redirect:http://localhost:9091/login";
    }

    /**
     * 查看session
     * @param httpSession
     */
    @GetMapping("/emp/getsession")
    @ApiOperation(value="查看session")
    public void getSession(HttpSession httpSession){
        if(httpSession.getAttribute("销售员") != null){
            System.out.println("销售员");
            EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("销售员");
            System.out.println(empInfo.toString());
        }else if(httpSession.getAttribute("跟单员") != null){
            System.out.println("跟单员");
        }else if(httpSession.getAttribute("财务人员") != null){
            System.out.println("财务人员");
        }
        System.out.println("什么都没了");
    }

    /**
     * 查看客户（搜索）
     * @param user_tel
     * @return
     */
    @RequestMapping(value = "/user/findByTel/{user_tel}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查看客户（搜索）")
    public Result userInfoFindByTel(@PathVariable("user_tel") String user_tel) {
        return ResultGenerator.genSuccessResult(userInfoService.findByUserTel(user_tel));
    }


    @RequestMapping(value = "/user/findByTelOrUserName/{search}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="查看客户（搜索）")
    public Result userInfoFindByTelOrUserName(@PathVariable("search") String search) {
        return ResultGenerator.genSuccessResult(userInfoService.findByUserTelOrUserName(search));
    }

    /**
     * 添加客户信息
     * @param userInfo
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加客户信息")
    public Result userRegister(@RequestBody UserInfo userInfo,HttpSession httpSession) {
        EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("销售员");
        if(empInfo == null){
            return ResultGenerator.genFailResult("参数异常！");
        }
        userInfo.setFirstSaleman(empInfo.getId());
        userInfo.setLastSaleman(empInfo.getId());
        if (StringUtils.isEmpty(userInfo.getUserName())
                || StringUtils.isEmpty(userInfo.getUserTel())
                || Objects.isNull(userInfo.getUserVip())) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        //empInfo.setCreateTime(new Date());
        // empInfo.setUpdateTime(new Date());
        String result = userInfoService.saveUserInfo(userInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 查看个人信息
     * @param httpSession
     * @return
     */
    @GetMapping("/emp/person")
    @ResponseBody
    @ApiOperation(value="查看个人信息")
    public Result getPersonInfo(HttpSession httpSession){
        if(httpSession.getAttribute("销售员") != null){
            EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("销售员");
            System.out.println(empInfo.toString());
            return ResultGenerator.genSuccessResult(empInfo);
        }else if(httpSession.getAttribute("跟单员") != null){
            EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("跟单员");
            System.out.println(empInfo.toString());
            return ResultGenerator.genSuccessResult(empInfo);
        }else if(httpSession.getAttribute("财务人员") != null){
            EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("财务人员");
            System.out.println(empInfo.toString());
            return ResultGenerator.genSuccessResult(empInfo);
        }
        return ResultGenerator.genFailResult("Session为空，未知异常");
    }


    /**
     * 修改个人信息
     * @param old_emp_pwd
     * @param new_emp_pwd
     * @param id
     * @return
     */
    @RequestMapping(value ="/emp/updatePerson", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改个人信息")
    public Result updatePersonInfo(@Param("old_emp_pwd") String old_emp_pwd, @Param("new_emp_pwd")String new_emp_pwd, @Param("id")Integer id){
        if (StringUtils.isEmpty(old_emp_pwd)
                || StringUtils.isEmpty(new_emp_pwd)
                || Objects.isNull(id)) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        String result = empInfoService.updateEmpPwdById(old_emp_pwd,new_emp_pwd,id);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 查看个人业绩信息（销售）
     * @param httpSession
     * @return
     */
    @GetMapping("/emp/personSaleman")
    @ResponseBody
    @ApiOperation(value="查看个人业绩信息")
    public Result personSale(HttpSession httpSession){
        if(httpSession.getAttribute("销售员") == null){
            return ResultGenerator.genFailResult("未登录");
        }
        EmpInfo temp = (EmpInfo)httpSession.getAttribute("销售员");

        return  ResultGenerator.genSuccessResult(empInfoService.getPersonSaleman(temp));
    }

    /**
     * 查看个人采购记录（跟单）
     * @param httpSession
     * @return
     */
    @GetMapping("/emp/personMerchandiser")
    @ResponseBody
    @ApiOperation(value="查看个人采购记录")
    public Result personMerchandiser(HttpSession httpSession){
        if(httpSession.getAttribute("跟单员") == null){
            return ResultGenerator.genFailResult("未登录");
        }
        EmpInfo temp = (EmpInfo)httpSession.getAttribute("跟单员");

        return  ResultGenerator.genSuccessResult(purchaseInfoService.getPersonMerchandiser(temp.getEmpId()));
    }


    /**
     * 查看个人审核采购记录（财务）
     * @param httpSession
     * @return
     */
    @GetMapping("/emp/personAccount")
    @ResponseBody
    @ApiOperation(value="查看个人审核采购记录")
    public Result personAccount(HttpSession httpSession){
        if(httpSession.getAttribute("财务人员") == null){
            return ResultGenerator.genFailResult("未登录");
        }
        EmpInfo temp = (EmpInfo)httpSession.getAttribute("财务人员");

        return  ResultGenerator.genSuccessResult(purchaseInfoService.getPersonAccount(temp.getEmpId()));
    }




    /**
     *购物车处理
     * @param goods_id
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/shopping-cart/{goods_id}",method = RequestMethod.GET)
    @ResponseBody
    public Result addShoppingCart(@PathVariable("goods_id") String goods_id,HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        //遍历，如果goods——id一样就sum+1
        if(list==null){
            //goods_id是goodsInfo的id，不是goodsId
            list = new ArrayList<ShoppingCartList>();
            list.add(new ShoppingCartList(goods_id,1));
        }else{
            int flag = 0;
            Iterator it = list.iterator();
            ShoppingCartList shoppingCartList;
            while(it.hasNext()){
                shoppingCartList = (ShoppingCartList)it.next();
                if(shoppingCartList.getGoodsId().equals(goods_id)){
                    shoppingCartList.setGoodsNum(shoppingCartList.getGoodsNum()+1);
                    flag = 1;
                }
            }
            if(flag == 0){
                list.add(new ShoppingCartList(goods_id,1));
            }
        }
        httpSession.setAttribute("shopping-cart",list);
        return ResultGenerator.genSuccessResult();
    }


    /**
     * 查看购物车session
     * @param httpSession
     */
    @GetMapping("/shop/getsession")
    @ApiOperation(value="查看购物车session")
    public void getShopSession(HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        for(ShoppingCartList shoppingCartList:list){
            System.out.println( shoppingCartList.toString());
        }
    }

    /**
     * 查看购物车
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/shoppingCartItem",method = RequestMethod.GET)
    @ResponseBody
    public Result shoppingCartItem(HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        List<GoodsInfoVO> goodsInfoVOS = new ArrayList<>();
        if(list !=null) {
            for (ShoppingCartList shoppingCartList : list) {
                System.out.println(shoppingCartList.toString());
                GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
                BeanUtil.copyProperties(goodsInfoMapper.selectByGoodsId(shoppingCartList.getGoodsId()), goodsInfoVO);
                goodsInfoVO.setGoodsNum(shoppingCartList.getGoodsNum());
                goodsInfoVOS.add(goodsInfoVO);
            }
        }
        return ResultGenerator.genSuccessResult(goodsInfoVOS);
    }

    /**
     * 查看购物车数量
     * @param httpSession
     * @return
     */
    @GetMapping("/shoppingCartItemNum")
    @ResponseBody
    @ApiOperation(value="查看购物车数量")
    public Result getShopCartItemNum(HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        Integer goodsNum = 0;
        if(list !=null) {
            for (ShoppingCartList shoppingCartList : list) {
                goodsNum += shoppingCartList.getGoodsNum();
            }
        }
        return ResultGenerator.genSuccessResult(goodsNum);
    }

    /**
     * 改变购物车数量
     * @param goods_num
     * @param goods_id
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/shoppingCartItem/changeNum",method = RequestMethod.GET)
    @ResponseBody
    public Result changeShoppingCartItemNum(@Param("goods_num")Integer goods_num, @Param("goods_id")String goods_id,HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        //遍历，如果goods——id一样就sum+1
            Iterator it = list.iterator();
            ShoppingCartList shoppingCartList;
            while(it.hasNext()){
                shoppingCartList = (ShoppingCartList)it.next();
                if(shoppingCartList.getGoodsId().equals(goods_id)){
                    shoppingCartList.setGoodsNum(goods_num);
                }
        }
        httpSession.setAttribute("shopping-cart",list);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/shoppingCartItem/delItem/{goods_id}",method = RequestMethod.GET)
    @ResponseBody
    public Result delShoppingCartItemNum(@PathVariable("goods_id")String goods_id,HttpSession httpSession){
        List<ShoppingCartList> list = (List<ShoppingCartList>) httpSession.getAttribute("shopping-cart");
        //遍历，如果goods——id一样就sum+1

        for(ShoppingCartList shoppingCartList:list){
            if(shoppingCartList.getGoodsId().equals(goods_id)){
                list.remove(shoppingCartList);
                break;
            }
        }
        httpSession.setAttribute("shopping-cart",list);
        return ResultGenerator.genSuccessResult();
    }
    /**
     *
     * 查看个人客户记录
     * @param httpSession
     * @return
     */
    @GetMapping("/userSaleList")
    @ResponseBody
    @ApiOperation(value="查看个人客户记录")
    public Result getUserSaleList(HttpSession httpSession){
        EmpInfo temp = (EmpInfo)httpSession.getAttribute("销售员");

        if(temp == null){
            return ResultGenerator.genFailResult("未登录");
        }
        return  ResultGenerator.genSuccessResult(userInfoService.selectByFirstEmpId(temp.getId()));
    }

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/del/{id}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="删除客户信息")
    public Result deleteUserInfo(@PathVariable("id") Integer id) {

        if (userInfoService.delUserInfo(id)>0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 修改客户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="修改客户信息")
    public Result updateUserInfo(@RequestBody UserInfo userInfo,HttpSession httpSession) {
        EmpInfo empInfo = (EmpInfo)httpSession.getAttribute("销售员");
        if(empInfo == null){
            return ResultGenerator.genFailResult("参数异常！");
        }
        userInfo.setLastSaleman(empInfo.getId());
        if (StringUtils.isEmpty(userInfo.getUserName())
                || StringUtils.isEmpty(userInfo.getUserTel())
                || Objects.isNull(userInfo.getUserSex())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = userInfoService.updateUserInfo(userInfo);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult(empInfo.getEmpName());
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

//    @GetMapping("/salesman/salesman_details_order/{order_id}")
//    public String detailOrders(@PathVariable("order_id") String order_id) {
//        System.out.println("aaa");
//        return  "/salesman/salesman_details_order.html";
//    }
}
