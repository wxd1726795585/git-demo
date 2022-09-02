package com.example.collect.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/2
 * \* Description:日期工具类——对于一些开发中经常碰到的日期格式化等,收集的日期工具类
 * \* @author 王祥栋
 */
public class DateUtils {

    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    ;
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期解析成字符串
     *
     * @param date 传入date类型的日期
     * @param flag 1 转成  yyyy-MM-dd格式 2 转成 yyyy-MM-dd HH:mm:ss格式
     * @return
     */
    public static String dateToString(Date date, Integer flag) {
        String format;
        if (flag == 1) {
            //转成  yyyy-MM-dd格式
            format = shortSdf.format(date);
        } else if (flag == 2) {
            //转成 yyyy-MM-dd HH:mm:ss格式
            format = longSdf.format(date);
        } else {
            format = null;
        }
        return format;
    }

    /**
     * 传入日期获取所在月的第一天(月初)
     *
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 传入日期获取所在月的最后一天(月末)
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 当前年的开始时间
     *
     * @return
     */
    public static Date getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * 当前年的结束时间
     *
     * @return
     */
    public static Date getCurrentYearEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * 计算两个日期之间相差的天数
     */
    public static int differenceDays(Date begin, Date end) {
        String startTime = shortSdf.format(begin);
        String endTime = shortSdf.format(end);
        String[] split = startTime.split("-");
        String[] split1 = endTime.split("-");
        int year1 = Integer.valueOf(split[0]);
        int month1 = Integer.valueOf(split[1]);
        int day1 = Integer.valueOf(split[2]);
        int year2 = Integer.valueOf(split1[0]);
        int month2 = Integer.valueOf(split1[1]);
        int day2 = Integer.valueOf(split1[2]);
        //year1距离公元元年的天数
        int sum = (year1 - 1) * 365;
        sum += (year1 - 1) / 4;
        //year1年month1月day1天经过多少天
        switch (month1) {
            case 12:
                sum += 30;//一定经过了11月，11月的天数加上
            case 11:
                sum += 31;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                if (year1 % 400 == 0 || year1 % 100 != 0 && year1 % 4 == 0) {
                    sum += 29;
                } else {
                    sum += 28;
                }
            case 2:
                sum += 31;
            case 1:
                sum += day1;
        }
        //year1距离公元元年的天数
        int sum2 = (year2 - 1) * 365;
        sum2 += (year2 - 1) / 4;
        //year1年month1月day1天经过多少天
        switch (month2) {
            case 12:
                sum2 += 30;//一定经过了11月，11月的天数加上
            case 11:
                sum2 += 31;
            case 10:
                sum2 += 30;
            case 9:
                sum2 += 31;
            case 8:
                sum2 += 31;
            case 7:
                sum2 += 30;
            case 6:
                sum2 += 31;
            case 5:
                sum2 += 30;
            case 4:
                sum2 += 31;
            case 3:
                if (year2 % 400 == 0 || year2 % 100 != 0 && year2 % 4 == 0) {
                    sum2 += 29;
                } else {
                    sum2 += 28;
                }
            case 2:
                sum2 += 31;
            case 1:
                sum2 += day2;
        }
        //判断两个天数的大小并进行计算
        if (sum > sum2) {
            return sum - sum2;
        } else {
            return sum2 - sum;
        }

    }
}
