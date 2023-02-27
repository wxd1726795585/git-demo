package com.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/9
 * \* Description:
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Test03 implements Cloneable{
    private String name;
    private Integer age;
    private final static SimpleDateFormat shortSdf =new SimpleDateFormat("yyyy-MM-dd");;
    private final static SimpleDateFormat longSdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
    static final String sy="222";

    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            test002();
        }catch (Exception e){
            throw new CloneNotSupportedException("222");
        }


    }

    public static void test002(){
        throw new ArrayIndexOutOfBoundsException("3343434");
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
