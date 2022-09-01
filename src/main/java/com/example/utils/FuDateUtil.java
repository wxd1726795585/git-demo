/*
 private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 */
package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author fuchangshun
 * @date 2018-12-05 17:49:10
 */
public final class FuDateUtil {

    public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String SIMPLE_DAY_FORMAT = "yyyy-MM-dd";
    public final static String DIAN_DAY_FORMAT = "yyyy.MM.dd";
    public final static String YYYY_MM_DD = "yyyyMMdd";
    private final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    private final static String MMDDHHMMSS = "MMddHHmmss";
    public final static String DATE_23_SUFFIX = " 23:59:59";
    public final static String DATE_00_SUFFIX = " 00:00:00";

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 获取当天的开始时间
     *
     * @return 当天0点0分0秒
     */
    public static Date getStartTime() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取 yyyy-MM-dd HH:mm:ss 格式的字符串
     *
     * @return 时间字符串
     */
    public static String getDateString() {
        return new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(new Date());
    }

    /**
     * 获取 yyyy-MM-dd HH:mm:ss 格式的字符串
     *
     * @return 时间字符串
     */
    public static Date getDateString(Date date) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DAY_FORMAT);


        String format = simpleDateFormat.format(date);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return parse;
    }

    public static Date yearAfter(Date date, int count) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();


        //过去一月
        c.setTime(date);
        c.add(Calendar.YEAR, count);
        c.add(Calendar.DATE, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        Date parse;
        try {
            parse = format.parse(mon);
        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
        return parse;
    }

    public static Date getYearAfter(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, i);
        Date time = calendar.getTime();
        Date dateString = getDateString(time);
        return dateString;
    }


    /**
     * 日解析
     *
     * @param day 日字符串
     * @return date
     */
    public static Date parseSimpleDay(String day) {
        try {
            return new SimpleDateFormat(SIMPLE_DAY_FORMAT).parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日解析
     *
     * @param day 日字符串
     * @return date
     */
    public static String parseDay(String day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DAY_FORMAT);
        String format = simpleDateFormat.format(day);
        return format;
    }

    /**
     * 获取n个月前时间
     *
     * @return date
     */
    public static Date parseDianDay(Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DIAN_DAY_FORMAT);
            Calendar c = Calendar.getInstance();


            //过去一月
            c.setTime(date);
            c.add(Calendar.DATE, -30);
            Date m = c.getTime();
            String mon = format.format(m);

            return format.parse(mon);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据不同的格式解析日期
     *
     * @param day
     * @param format
     * @return
     */
    public static Date parseDay(String day, String format) {
        try {
            return new SimpleDateFormat(format).parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取 yyyyMMdd 格式的字符串
     *
     * @return 时间字符串
     */
    public static String yyyyMMdd(Date date) {
        return new SimpleDateFormat(YYYY_MM_DD).format(date);
    }

    /**
     * 获取 yyyy-MM-dd 格式的字符串
     *
     * @return 时间字符串
     */
    public static String yyyy_MM_dd(Date date) {
        return new SimpleDateFormat(SIMPLE_DAY_FORMAT).format(date);
    }

    /**
     * 根据不同的格式返回日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String YYYYMMDDHHMMSS(Date date) {
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(date);
    }

    public static String MMDDHHMMSS(Date date) {
        return new SimpleDateFormat(MMDDHHMMSS).format(date);
    }


    public static int getAge(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        //出生日期晚于当前时间，无法计算
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        //当前年份
        int yearNow = cal.get(Calendar.YEAR);
        //当前月份
        int monthNow = cal.get(Calendar.MONTH);
        //当前日期
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //计算整岁数
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //当前日期在生日之前，年龄减一
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }

            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    public static Date getMonthBegin(Date date) throws ParseException {
        SimpleDateFormat aDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);


        // 获取本月第一天的时间
        return aDateFormat.parse(aDateFormat.format(c.getTime()));

    }

    public static  Date getMonthEnd(Date date) throws ParseException {
        //设置时间格式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获得实体类
        Calendar ca = Calendar.getInstance();
        //设置最后一天
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至0
        ca.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        ca.set(Calendar.MINUTE, 59);
        //将秒至0
        ca.set(Calendar.SECOND, 59);
        //最后一天格式化
        String lastDay = format.format(ca.getTime());


        // 获取本月第一天的时间
        return format.parse(lastDay);

    }

}





