package com.jwz.salesteam.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/21 16:39
 * @description：页面跳转
 * @modified By：
 * @version:
 */
@Controller
public class pageConsult {

    @GetMapping("/admin/admin_add_goods")
    public String admin_add_goods(){
        return "/admin/admin_add_goods.html";
    }

    @GetMapping("/admin/admin_add_member")
    public String admin_add_member(){
        return "/admin/admin_add_member.html";
    }

    @GetMapping("/admin/admin_addeidt_provider")
    public String admin_addeidt_provider(){
        return "/admin/admin_addeidt_provider.html";
    }

    @GetMapping("/admin/admin_manage_goods")
    public String admin_manage_goods(){
        return "/admin/admin_manage_goods.html";
    }

    @GetMapping({"/admin/admin_manage_members","/admin"})
    public String admin_manage_members(){
        return "/admin/admin_manage_members.html";
    }

    @GetMapping("/admin/admin_manage_user")
    public String admin_manage_user(){
        return "/admin/admin_manage_user.html";
    }

    @GetMapping("/admin/admin_show_goods")
    public String admin_show_goods(){
        return "/admin/admin_show_goods.html";
    }

    @GetMapping("/admin/admin_details_goods")
    public String admin_details_goods(){
        return "/admin/admin_details_goods.html";
    }

    @GetMapping({"/merchandiser/merchandiser_orders_list","/merchandiser"})
    public String merchandiser_orders_list(){
        return "/merchandiser/merchandiser_orders_list.html";
    }

    @GetMapping("/merchandiser/merchandiser_orders_history")
    public String merchandiser_orders_history(){
        return "/merchandiser/merchandiser_orders_history.html";
    }

    @GetMapping("/merchandiser/merchandiser_security")
    public String merchandiser_security(){
        return "/merchandiser/merchandiser_security.html";
    }


    @GetMapping("/account/account_orders_ profit")
    public String account_orders_profit(){
        return "/account/account_orders_ profit.html";
    }

    @GetMapping("/account/account_orders_check")
    public String account_orders_check(){
        return "/account/account_orders_check.html";
    }


    @GetMapping({"/account/account_orders_count","/account"})
    public String account_orders_count(){
        return "/account/account_orders_count.html";
    }


    @GetMapping("/account/account_orders_history")
    public String account_orders_history(){
        return "/account/account_orders_count.html";
    }

    @GetMapping("/account/account_security")
    public String account_security(){
        return "/account/account_security.html";
    }



    @GetMapping({"/salesman/salesman_add_user","/saleman"})
    public String salesman_add_user(){
        return "/salesman/salesman_add_user.html";
    }

    @GetMapping("/salesman/salesman_details_goods")
    public String salesman_details_goods(){
        return "/salesman/salesman_details_goods.html";
    }

    @GetMapping("/salesman/salesman_details_order")
    public String salesman_details_order(){
        return "/salesman/salesman_details_order.html";
    }

    @GetMapping("/salesman/salesman_manage_order")
    public String salesman_manage_order(){
        return "/salesman/salesman_manage_order.html";
    }

    @GetMapping("/salesman/salesman_manage_user")
    public String salesman_manage_user(){
        return "/salesman/salesman_manage_user.html";
    }

    @GetMapping("/salesman/salesman_personal_information")
    public String salesman_personal_information(){
        return "/salesman/salesman_personal_information.html";
    }

    @GetMapping("/salesman/salesman_security")
    public String salesman_security(){
        return "/salesman/salesman_security.html";
    }

    @GetMapping("/salesman/salesman_shop_cart")
    public String salesman_shop_cart(){
        return "/salesman/salesman_shop_cart.html";
    }

    @GetMapping("/salesman/salesman_show_goods")
    public String salesman_show_goods(){
        return "/salesman/salesman_show_goods.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "/login2.html";
    }

}
