package com.example;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/14
 * \* Description:
 * \* @author 王祥栋
 */
public class Test11222 {
    public static void main(String[] args) {
        String str="2021-03-01";
        String str1="2021-03-31";
        int i = diffDays(str.split("-"), str1.split("-"));
        System.out.println(i);
    }

    /**
     * 传入日期获取所在月的第一天
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
     * 传入日期获取所在月的最后一天
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
    @Test
    public void test001(){
        //当前日期是202205
        int i=50;
        String str="202205";
        ArrayList<String> strings = new ArrayList<>(i);
        //现存当前的年月
        strings.add(str);
        for (int j = 0; j < i-1; j++) {
            String s1 = strings.get(j);
            if (s1.substring(4,6).equals("01")){
                String substring = s1.substring(0, 4);
                Integer integer = Integer.valueOf(substring);
                integer=integer-1;
                strings.add(String.valueOf(integer)+"12");
                continue;
            }
            //不是特殊情况
            Integer integer1 = Integer.valueOf(s1);
            String s = String.valueOf(integer1 - 1);
            strings.add(s);
            continue;
        }
        //
        System.out.println(strings);
    }

    public static int diffDays(String[] beginDate, String[] endDate) {
        LocalDate begin = LocalDate.of(Integer.valueOf(beginDate[0]), Integer.valueOf(beginDate[1]), Integer.valueOf(beginDate[2]));
        LocalDate end = LocalDate.of(Integer.valueOf(endDate[0]), Integer.valueOf(endDate[1]), Integer.valueOf(endDate[2]));
        Period period = Period.between(begin, end);

        return period.getDays();
    }
    public static Date addDays(Date beginDate, int days) {
        Date endDate = new Date();
        long end = beginDate.getTime() + 1000 * 60 * 60 * 24 * days;
        endDate.setTime(end);
        return endDate;
    }


}

























