package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.config.AccountInfoBean;
import com.example.exception.CustomizationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/7/7
 * \* Description:
 * \* @author 王祥栋
 */
public class TestDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String SIMPLE_DAY_FORMAT = "yyyy-MM-dd";

    @Test
    public void redis() throws Exception {
        for (int i = 0; i < 500; i++) {
            label1:
            {
                System.out.println(i);
                for (int j = 0; j < 100; j++) {
                    if (j == 10) {
                        break;
                    }
                }
                break label1;
            }
        }
    }


    private void testCanShu(Integer... integers) {
        List<Integer> integers1 = Arrays.asList(integers);

    }


    private String getString(String param) {
        switch (param) {
            case "a":
                System.out.println("a");
                break;
            default:
                System.out.println("11111");
        }
        int i = 1 / 0;
        return "1";
    }

    /**
     * 判断字符串中是否包含中文汉字
     *
     * @param content
     * @return true至少包含1个
     */
    public static boolean hasChinese(CharSequence content) {
        if (null == content) {
            return false;
        }
        String regex = "[\u2E80-\u2EFF\u2F00-\u2FDF\u31C0-\u31EF\u3400-\u4DBF\u4E00-\u9FFF\uF900-\uFAFF\uD840\uDC00-\uD869\uDEDF\uD869\uDF00-\uD86D\uDF3F\uD86D\uDF40-\uD86E\uDC1F\uD86E\uDC20-\uD873\uDEAF\uD87E\uDC00-\uD87E\uDE1F]+";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(content).find();
    }


    public static Date getNextYearPreDay(Date date) {
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        ca.setTime(date);   //设置时间为当前时间
        ca.add(Calendar.YEAR, +1); //年份+1
        // ca.add(Calendar.MONTH, -1); // 月份-1
        return ca.getTime();
    }

    //以下3个是错误的重载
    public int getSum(int i, int j) {
        return 0;
    }
    //

    //public void getSum(int m,int n){
    //
    //}

    //private void getSum(int i,int j){
    //
    //}


}

class CeShi {
    private CeshiA ceshiA;
}

class CeshiA {
    private CeShiB[] list;
}

@AllArgsConstructor
@Data
class CeShiB {
    private String name;
    private String age;
}