package com.jwz.salesteam.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberUtil {

    private NumberUtil() {
    }


    /**
     * 判断是否为11位电话号码
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 生成指定长度的随机数
     *
     * @param length
     * @return
     */
    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 生成订单流水号
     *
     * @return
     */
    public static String genOrderNo() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(4);
        buffer.append(num);
        return buffer.toString();
    }

    /**
     * 生成采购单流水号
     *
     * @return
     */
    public static String genPurchaseNo() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(5);
        buffer.append(num);
        return buffer.toString();
    }

    /**
     * 生成职员id
     *
     */
    public static String genEmpId() {
        StringBuffer buffer = new StringBuffer("8009");
        int num = genRandomNum(5);
        buffer.append(num);
        return buffer.toString();
    }

    public static String getGoodsId() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        return buffer.toString();
    }

    public static String genSupplierId() {
        StringBuffer buffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
        int num = genRandomNum(6);
        buffer.append(num);
        return buffer.toString();
    }
}
