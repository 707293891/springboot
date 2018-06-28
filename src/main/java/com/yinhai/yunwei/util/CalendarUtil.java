package com.yinhai.yunwei.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author 范超
 * @version V1.0
 * @Title CalendarUtil
 * @Package com.yinhai.yunwei.util
 * @Descript :TODO()
 * @date : 2018/6/25  下午4:09
 */
public class CalendarUtil {

    private static Calendar instance(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-7);
        return calendar;
    }

    public static int getYear(){
        return instance().getWeekYear();
    }

    public static int getWeekNum(){
        return instance().get(Calendar.WEEK_OF_MONTH);
    }
    public static int getMonth() {
        return instance().get(Calendar.MONTH)+1;
    }
    public static String dateFormate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(instance().getTime());
    }
    public static String  yearMonthWeek(){
        StringBuilder builder=new StringBuilder();
        builder.append(CalendarUtil.getYear())
                .append("年")
                .append(CalendarUtil.getMonth())
                .append("月第")
                .append(CalendarUtil.getWeekNum())
                .append("周");
        return builder.toString();
    }
}
