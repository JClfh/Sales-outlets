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

    @GetMapping("/admin/admin_add_member")
    public String admin_add_member(){
        return "/admin/admin_add_member.html";
    }

    @GetMapping("/admin/admin_manage_members")
    public String admin_manage_members(){
        return "/admin/admin_manage_members.html";
    }

    @GetMapping("/admin/admin_manage_user")
    public String admin_manage_user(){
        return "/admin/admin_manage_user.html";
    }

    @GetMapping("/admin/admin_add_goods")
    public String admin_add_goods(){
        return "/admin/admin_add_goods.html";
    }

    @GetMapping("/admin/admin_manage_goods")
    public String admin_manage_goods(){
        return "/admin/admin_manage_goods.html";
    }

    @GetMapping("/admin/admin_show_goods")
    public String admin_show_goods(){
        return "/admin/admin_show_goods.html";
    }

    @GetMapping("/merchandiser/merchandiser_orders_list")
    public String merchandiser_orders_list(){
        return "/merchandiser/merchandiser_orders_list.html";
    }

    @GetMapping("/account/account_orders_check")
    public String account_orders_check(){
        return "/account/account_orders_check.html";
    }

    @GetMapping("/account/account_orders_count")
    public String account_orders_count(){
        return "/account/account_orders_count.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

}
