package com.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Liuruizhi
 * @date 2020/6/1 下午2:42
 */
public class DateUtil {
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    ;
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ;

    //开始时间转换
    public static Date getBeginDateTime(String beginDate) {
        if (StringUtils.isBlank(beginDate)) {
            return null;
        }
        String s = "/";
        if (beginDate.indexOf(s) != -1) {
            beginDate = beginDate.replaceAll(s, "-");
            String[] e = beginDate.split("\\-");

            int e1;
            int i;
            for (e1 = 1; e1 <= 9; ++e1) {
                i = Integer.parseInt(e[1]);
                if (e1 == i) {
                    e[1] = "0" + String.valueOf(e1);
                    break;
                }
            }

            for (e1 = 1; e1 <= 9; ++e1) {
                i = Integer.parseInt(e[2]);
                if (e1 == i) {
                    e[2] = "0" + String.valueOf(e1);
                    break;
                }
            }

            beginDate = e[0] + "-" + e[1] + "-" + e[2];
        }

        Date beginDateTime = null;

        try {
            beginDateTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(beginDate.substring(0, 10) + " 00:00:00");
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return beginDateTime;
    }

    //结束时间转换
    public static Date getEndDateTime(String endDate) {
        if (StringUtils.isBlank(endDate)) {
            return null;
        }
        String s = "/";
        if (endDate.indexOf(s) != -1) {
            endDate = endDate.replaceAll(s, "-");
            String[] endDateTime = endDate.split("\\-");

            int e;
            int i;
            for (e = 1; e <= 9; ++e) {
                i = Integer.parseInt(endDateTime[1]);
                if (e == i) {
                    endDateTime[1] = "0" + String.valueOf(e);
                    break;
                }
            }

            for (e = 1; e <= 9; ++e) {
                i = Integer.parseInt(endDateTime[2]);
                if (e == i) {
                    endDateTime[2] = "0" + String.valueOf(e);
                    break;
                }
            }

            endDate = endDateTime[0] + "-" + endDateTime[1] + "-" + endDateTime[2];
        }

        Date endDateTime = null;

        try {
            endDateTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endDate.substring(0, 10) + " 23:59:59");
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return endDateTime;
    }

    public static int diffDays(String[] beginDate, String[] endDate) {
        LocalDate begin = LocalDate.of(Integer.valueOf(beginDate[0]), Integer.valueOf(beginDate[1]), Integer.valueOf(beginDate[2]));
        LocalDate end = LocalDate.of(Integer.valueOf(endDate[0]), Integer.valueOf(endDate[1]), Integer.valueOf(endDate[2]));
        Period period = Period.between(begin, end);

        return period.getDays();
    }

    public static int diffDaysFromNow(String date) {
        String[] arrayDate = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(arrayDate[0]), Integer.valueOf(arrayDate[1]), Integer.valueOf(arrayDate[2]));
        Period period = Period.between(LocalDate.now(), localDate);
        return period.getDays();
    }

    public static Date addDays(Date beginDate, int days) {
        Date endDate = new Date();
        long end = beginDate.getTime() + 1000 * 60 * 60 * 24 * days;
        endDate.setTime(end);
        return endDate;
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
    /**
     * 计算两个日期之间相差的整数
     */
    public static int differenceDays(Date begin, Date end) {
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
            return sum-sum2;
           /* System.out.println("间隔的时间天数为:" + (sum - sum2));
            System.out.println("间隔的周数为:" + (sum - sum2) / 7);*/
        } else {
            return sum2-sum;
            /*System.out.println("间隔的时间天数为:" + (sum2 - sum));
            System.out.println("间隔的周数为:" + (sum2 - sum) / 7);*/
        }

    }

    public static Date stringToDate(String date){
        Date parse=null;
        try {
            parse = shortSdf.parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 获取Date类型的一天的起始值
     * @param date
     * @return
     * @throws Exception
     */
    public static Date getDateTypeBeginDay(Date date) throws Exception{
        if (date==null){
            return null;
        }
        String format = longSdf.format(date);
        Date parse = longSdf.parse(format.substring(0, 10) + " 00:00:00");
        return parse;
    }

    /**
     * 获取Date类型的一天的起始值
     * @param date
     * @return
     * @throws Exception
     */
    public static Date getDateTypeEndDay(Date date) throws Exception{
        if (date==null){
            return null;
        }
        String format = longSdf.format(date);
        Date parse = longSdf.parse(format.substring(0, 10) + " 23:59:59");
        return parse;
    }
    public static void main(String[] args) {
//        Date beginDate = getBeginDateTime("2021-08-29");
//        Date endDate = getEndDateTime("2021-09-02");
//
//        System.out.println(beginDate.toString());
//        System.out.println(endDate.toString());
//        System.out.println(diffDays("2021-08-29".split("-"), "2021-09-02".split("-")));
//        System.out.println(addDays(beginDate, 4).toString());
//        LocalDate nowDate = LocalDate.now();
//        String[] begin = "2021-09-04".split("-");
//        LocalDate beginDate = LocalDate.of(Integer.valueOf(begin[0]), Integer.valueOf(begin[1]), Integer.valueOf(begin[2]));
//        Period period = Period.between(nowDate, beginDate);
//        System.out.println(period.getDays());
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(addDays(new Date(), 1)));
//        System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    }
}
