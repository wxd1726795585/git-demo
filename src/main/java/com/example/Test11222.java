package com.example;

import com.example.bean.CooperationReq;
import com.example.bean.CooperativEevaluation;
import com.example.bean.Demo01Bean;
import com.example.bean.Demo02Bean;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/14
 * \* Description:
 * \* @author 王祥栋
 */
public class Test11222 {
    /**
     * 阅读状态标记
     */
    private static final String READING_STATE_FLAG = "READING_STATE_FLAG";

    public static void main(String[] args) throws ParseException {
        String str="5220010103687788";
        System.out.println(str.length());
    }

    public static String cooperatorNameFilter(String name) {
        return StringUtils.isEmpty(name) ? name : name.replaceAll("[0-9]*[D-Z]", "");
    }

    public static String dateNextDay(String ceShi) {
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date temp = dft.parse(ceShi);
            Calendar cld = Calendar.getInstance();
            cld.setTime(temp);
            cld.add(Calendar.DATE, 1);
            temp = cld.getTime();
            //获得下一天日期字符串
            String nextDay = dft.format(temp);
            return nextDay;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 计算两个日期之间相差的整数,日期是××××年××月××日００时００分００秒 如果不足一个月按照一个月计算
     */
    public static int days(Date begin, Date end) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = simpleDateFormat.format(begin);
        String endTime = simpleDateFormat.format(end);
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
           /* System.out.println("间隔的时间天数为:" + (sum - sum2));
            System.out.println("间隔的周数为:" + (sum - sum2) / 7);*/
        } else {
            return sum2 - sum;
            /*System.out.println("间隔的时间天数为:" + (sum2 - sum));
            System.out.println("间隔的周数为:" + (sum2 - sum) / 7);*/
        }

    }

    public static int betweenMonth(Date begina, Date end) {

        Calendar begin = Calendar.getInstance();
        begin.setTime(begina);
        int beginYear = begin.get(Calendar.YEAR);
        int beginMonth = begin.get(Calendar.MONTH);
        int beginDay = begin.get(Calendar.DAY_OF_MONTH);

        Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        int endYear = endTime.get(Calendar.YEAR);
        int endMonth = endTime.get(Calendar.MONTH);
        int endDay = endTime.get(Calendar.DAY_OF_MONTH);

        int between = (endYear - beginYear) * 12 + (endMonth - beginMonth);

        if (endDay > beginDay)
            between = between + 1;
        else if (endDay < beginDay)
            between = between - 1;
        return between;
    }

    /**
     * 传入日期获取所在月的第一天
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
     * 传入日期获取所在月的最后一天
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

    @Test
    public void test001() {
        //当前日期是202205
        int i = 50;
        String str = "202205";
        ArrayList<String> strings = new ArrayList<>(i);
        //现存当前的年月
        strings.add(str);
        for (int j = 0; j < i - 1; j++) {
            String s1 = strings.get(j);
            if (s1.substring(4, 6).equals("01")) {
                String substring = s1.substring(0, 4);
                Integer integer = Integer.valueOf(substring);
                integer = integer - 1;
                strings.add(String.valueOf(integer) + "12");
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

    public static int diffDaysFromNow(String date) {
        String[] arrayDate = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(arrayDate[0]), Integer.valueOf(arrayDate[1]), Integer.valueOf(arrayDate[2]));
        Period period = Period.between(LocalDate.now(), localDate);
        return period.getDays();
    }

}

























