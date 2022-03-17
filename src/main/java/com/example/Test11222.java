package com.example;

import org.junit.Test;

import java.math.BigDecimal;
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
        System.out.println( getFirstDayDateOfMonth(new Date()));
        System.out.println(getLastDayOfMonth(new Date()));
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
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecimal1 = new BigDecimal("11");
        BigDecimal bigDecimal2 = new BigDecimal("10");
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
}
