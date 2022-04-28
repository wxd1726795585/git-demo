package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author wuxiaobo
 * @date 2019/7/23 12:36
 */
public class TimeAssist {
    public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public final static SimpleDateFormat TIME_STAMP_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public final static SimpleDateFormat SIMPLE_DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd");
    static DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter YEAR_MON_FORMATTER = DateTimeFormatter.ofPattern("yyyyMM");
    static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmmss");
    static DateTimeFormatter DAY_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");


    public static final String ZERO = " 00:00:00";
    public static final String DAY_END = " 23:59:59";
    public static Map<Integer, List<String>> QUARTER;

    static {
        QUARTER = new HashMap<>();
        QUARTER.put(1, new ArrayList<>());
        QUARTER.put(2, new ArrayList<>(Collections.singletonList("01")));
        QUARTER.put(3, new ArrayList<>(Arrays.asList("01", "02")));
        QUARTER.put(4, new ArrayList<>(new ArrayList<>()));
        QUARTER.put(5, new ArrayList<>(Collections.singletonList("04")));
        QUARTER.put(6, new ArrayList<>(Arrays.asList("04", "05")));
        QUARTER.put(7, new ArrayList<>());
        QUARTER.put(8, new ArrayList<>(Collections.singletonList("07")));
        QUARTER.put(9, new ArrayList<>(Arrays.asList("07", "08")));
        QUARTER.put(10, new ArrayList<>());
        QUARTER.put(11, new ArrayList<>(Collections.singletonList("10")));
        QUARTER.put(12, new ArrayList<>(Arrays.asList("10", "11")));
    }
//    static {
//        QUARTER = new HashMap<>();
//        QUARTER.put(1, new ArrayList<>());
//        QUARTER.put(2, new ArrayList<>(Collections.singletonList("01")));
//        QUARTER.put(3, new ArrayList<>(Arrays.asList("01", "02")));
//        QUARTER.put(4, new ArrayList<>(new ArrayList<>()));
//        QUARTER.put(5, new ArrayList<>(Collections.singletonList("04")));
//        QUARTER.put(6, new ArrayList<>(Arrays.asList("04", "05")));
//        QUARTER.put(7, new ArrayList<>());
//        QUARTER.put(8, new ArrayList<>(Collections.singletonList("07")));
//        QUARTER.put(9, new ArrayList<>(Arrays.asList("07", "08")));
//        QUARTER.put(10, new ArrayList<>());
//        QUARTER.put(11, new ArrayList<>(Arrays.asList("09","10")));
//        QUARTER.put(12, new ArrayList<>(Arrays.asList("10", "11")));
//    }

    /**
     * 字符串形式获取今天的年月日
     *
     * @return yyyyMMdd
     */
    public static String today() {
        return DAY_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * n天之后
     *
     * @param n 天数
     * @return yyyyMMdd
     */
    public static String nDayLater(int n) {
        return DAY_FORMATTER.format(LocalDateTime.now().plusDays(n));
    }

    /**
     * 获取n年之后的时间
     *
     * @param n 年
     * @return yyyyMMdd
     */
    public static String nYearLater(int n) {
        return DAY_FORMATTER.format(LocalDateTime.now().plusYears(n));
    }

    /**
     * n个月后
     *
     * @param n n
     * @return yyyyMM
     */
    public static String nMonthLater(int n) {
        return YEAR_MON_FORMATTER.format(LocalDateTime.now().plusMonths(n));
    }

    /**
     * n个小时后
     *
     * @param n n
     * @return 获取n小时之后的时间
     */
    public static String nHourLater(int n) {
        return DAY_TIME_FORMATTER.format(LocalDateTime.now().plusHours(n));
    }

    /**
     * SimpleDateFormat
     * 获取n分钟后的时间
     *
     * @param n n
     * @return yyyyMMddHHmmss
     */
    public static String nMinutesLater(int n) {
        return DAY_TIME_FORMATTER.format(LocalDateTime.now().plusMinutes(n));
    }

    /**
     * 字符串形式获取当前的时分秒
     *
     * @return HHmmss
     */
    public static String now() {
        return TIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 字符串形式获取年月日时分秒
     *
     * @return yyyyMMddHHmmss
     */
    public static String todayFull() {
        return DAY_TIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 字符串形式获取年月日时分秒
     *
     * @return yyyyMMddHHmmss
     */
    public static String yearMon() {
        return YEAR_MON_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 格式化
     *
     * @param date 日期
     * @return {@link String}
     */
    public static String yearMon(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }

    /**
     * 格式化
     *
     * @param date 日期
     * @return {@link String}
     * @throws ParseException 解析异常
     */
    public static String yearMon(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(date);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");
        return sdf1.format(parse);
    }


    /**
     * 获取指定格式的时间
     *
     * @param pattern 指定时间格式
     * @return {@link String}
     */
    public static String geTime(String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now());
    }


    /**
     * 根据 两个Date 判断时间差是否在指定时间内
     *
     * @param timeOut   小时
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return boolean
     */
    public static boolean isBetweenDate(Date startDate, Date endDate, long timeOut) {

        long between = endDate.getTime() - startDate.getTime();
        if (between <= (timeOut * 3600000)) {
            return true;
        }
        return false;
    }

    /**
     * 获取两个时间之间的时间差(秒)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return long
     * @throws ParseException 解析异常
     */
    public static long getTimeDifference(String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);
        return (end.getTime() - start.getTime()) / 1000;
    }

    /**
     * 获取date
     *
     * @param date             日期
     * @param simpleDateFormat 简单的日期格式
     * @return {@link Date}
     */
    public static Date getTime(String date, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 月初时间
     *
     * @return
     */
    public static Date getInitalOfMonth() {
        String format = SIMPLE_DATE_FORMAT2.format(new Date()) + ZERO;
        try {
            return SIMPLE_DATE_FORMAT.parse(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前季度时间
     *
     * @return 如当前时间202001 返回202002,202003; 当前时间202002 返回202001;当前时间202003 返回202001,202002
     */
    public static List<String> getQuarterOtherTime() {
        LocalDate now = LocalDate.now();
        int monthValue = now.getMonthValue();
        List<String> list = QUARTER.get(monthValue);
        int year = now.getYear();
        String yearString = String.valueOf(year);
        List<String> time = new ArrayList<>();
        for (String month : list) {
            String concat = yearString.concat(month);
            time.add(concat);
        }
        return time;
    }

    /**
     * 获取当前季度时间
     *
     * @return 如当前时间202001 返回202002,202003; 当前时间202002 返回202001;当前时间202003 返回202001,202002
     */
    public static List<String> getQuarterOtherTime(String yyyyMM) {
        String yearString = yyyyMM.substring(0, 4);
        int monthValue = Integer.parseInt(yyyyMM.substring(4));
        List<String> list = QUARTER.get(monthValue);
        List<String> time = new ArrayList<>();
        for (String month : list) {
            String concat = yearString.concat(month);
            time.add(concat);
        }
        return time;
    }

}
