package com.admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    // 对日期格式进行处理

    public static  String date2String(Date date ,String pattern){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStr = simpleDateFormat.format(date);
        System.out.println("使用了此工具类 ： date2String");
        return dateStr;
    }

    public static Date string2Date(String str ,String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(str);
        return  date;
    }

}
