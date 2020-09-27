package com.jwz.salesteam.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/25 19:27
 * @description：
 * @modified By：
 * @version:
 */
public class DateUtil {
   public static boolean isSameDay(Date date1,Date date2){
        if(date1 != null && date2 != null){
        Calendar cal1=Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2=Calendar.getInstance();
        cal2.setTime(date2);
        System.out.println(cal1+"***"+cal2);
        return isSameDay(cal1,cal2);
        }else{
        throw new IllegalArgumentException("Thedatemustnotbenull");
        }
}
 
    public static boolean isSameDay(Calendar cal1,Calendar cal2){
        if(cal1 != null && cal2 != null){
        return cal1.get(0)==cal2.get(0)&&cal1.get(1)==cal2.get(1)&&cal1.get(6)==cal2.get(6);
        }else{
        throw new IllegalArgumentException("Thedatemustnotbenull");
    }
}


}
