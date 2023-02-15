package com.example;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/9
 * \* Description:
 */
public class Test03 {

    private final static SimpleDateFormat shortSdf =new SimpleDateFormat("yyyy-MM-dd");;
    private final static SimpleDateFormat longSdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        List<String> list1=new ArrayList<>();
        list1.add("111");
        list1.add("222");
        list1.add("333");
        boolean b = list.removeAll(list1);
        System.out.println(list);

    }

    /**
     * 当前年的开始时间，即2012-01-01 00:00:00
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
     * 当前年的结束时间，即2012-12-31 23:59:59
     *
     * @return
     */
    public static  Date getCurrentYearEndTime() {
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




}
