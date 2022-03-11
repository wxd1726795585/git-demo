package com.example;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/15
 * \* Description:
 */
public class Test04 {
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    public static void main(String[] args) throws Exception {
        /*BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimal1 = new BigDecimal("-1");
        if ("1".equals(bigDecimal1.compareTo(bigDecimal))){
            System.out.println(1);
        }
        System.out.println(bigDecimal1.compareTo(bigDecimal));
        *//*BigDecimal bigDecimal = new BigDecimal("-1");
        BigDecimal add = bigDecimal.add(new BigDecimal("1"));
        System.out.println(add);*//*
        boolean b = isXiaoShu("-5.0");
        System.out.println(b);*/
        String str="56";
        boolean numeric = isNumeric(str);
        System.out.println(numeric);
    }
    //判断正整数
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * use
     * 判断是否为正/负整数
     */
    static boolean isPosOrNegInteger(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        boolean rst = pattern.matcher(str).matches();

        return rst;
    }
    /**
     * 利用正则表达式来判断字符串是否为数字
     */
    public static boolean checkStrIsNum02(String str) {
        String bigStr;
        try {
            /** 先将str转成BigDecimal，然后在转成String */
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            /** 如果转换数字失败，说明该str并非全部为数字 */
            return false;
        }
        Matcher isNum = NUMBER_PATTERN.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * use
     * 判断是否为小数
     */
    static boolean isXiaoShu(String str) {
        if (StringUtils.isBlank(str)||str.contains("-")) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");
        boolean rst = pattern.matcher(str).matches();

        return rst;
    }



}

