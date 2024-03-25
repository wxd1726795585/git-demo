package com.example.test;

import cn.hutool.core.convert.NumberChineseFormatter;
import com.example.base.BusinessException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/22
 * \* Description:
 * \* @author 王祥栋
 */
public class ThreadTest extends Thread {

    private static final Integer CORE_POOL_SIZE = 10;
    private static final Integer MAX_POOL_SIZE = 20;
    private static final Long KEEP_ALIVE_TIME = 20L;
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());
    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UPPER_UNIT = {"", "拾", "佰", "仟"};
    private static final String[] CN_UPPER_SECTION = {"", "万", "亿"};

    public static String numberToChinese(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            return CN_UPPER_NUMBER[0];
        }

        StringBuilder result = new StringBuilder();
        int unitIndex = 0;
        boolean needZero = false;  // 是否需要补零

        while (number.compareTo(BigDecimal.ZERO) > 0) {
            int digit = number.remainder(new BigDecimal(10)).intValue();
            if (digit == 0) {
                // 当前数字是零
                if (needZero) {
                    result.insert(0, CN_UPPER_NUMBER[digit]);
                    needZero = false; // 重置补零标志
                }
            } else {
                result.insert(0, CN_UPPER_UNIT[unitIndex]);
                result.insert(0, CN_UPPER_NUMBER[digit]);
                needZero = true; // 设置需要补零
            }

            // 处理完当前数字，移位到下一位
            number = number.divide(new BigDecimal(10), 0, BigDecimal.ROUND_DOWN);
            if (number.compareTo(BigDecimal.ZERO) > 0 || (!needZero && unitIndex % 4 == 0)) {
                // 当前数字非零，或者需要补零时，添加单位
                result.insert(0, CN_UPPER_SECTION[unitIndex / 4]);
            }

            // 移动单位索引
            unitIndex = (unitIndex + 1) % 4;
        }

        return result.toString();
    }

    public static String test() throws Exception{
        try {
            test01();
            int a= 10;
            return "test";
        }catch (Exception e){
            throw  e;
        }

    }

    public static void main(String[] args) {
        String s = numberToChinese(new BigDecimal("1123456.89"));
        System.out.println(s);
    }

    public static String test01() throws Exception{
        int a= 10;
        return "test";
    }


}


