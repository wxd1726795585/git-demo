package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.req.StudentReq;
import com.example.utils.DateUtil;
import com.example.utils.TimeAssist;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/7/18
 * \* Description:替换年月日
 * \* @author 王祥栋
 */
@Slf4j
public class Test116116 {
        /*Date date = new Date();
        //获取该date时间的月初
        Date firstDayDateOfMonth = DateUtil.getFirstDayDateOfMonth(date);
        ////获取该date时间的月末
        Date lastDayOfMonth = DateUtil.getLastDayOfMonth(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMM");
        //转换成字符串yyyy-MM-dd HH:mm:ss格式
        String firstDayFormat = simpleDateFormat.format(firstDayDateOfMonth);
        String lastDayFormat = simpleDateFormat.format(lastDayOfMonth);
        //便于查询
        Date firstTime = TimeAssist.getTime(firstDayFormat.substring(0, 10) + " 00:00:00", TimeAssist.SIMPLE_DATE_FORMAT);
        Date lastTime = TimeAssist.getTime(lastDayFormat.substring(0, 10) + " 23:59:59", TimeAssist.SIMPLE_DATE_FORMAT);
    }

    private static String getDate(String date){
        String s = date.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "").trim();*/


        public static void main(String[] args) {
            String str="中国任命银行总行";
            String hang = str.substring(0, str.indexOf("行")+1);
            System.out.println(hang);
        }
    /**
     * 开票日期格式化
     * @param invoiceDate
     * @return
     */
    private static String invoiceDateFormat(String invoiceDate){
        if (invoiceDate.contains("年") && invoiceDate.contains("月") && invoiceDate.contains("日")){
            String invoiceDateFormat = invoiceDate.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "").trim();
            return invoiceDateFormat;
        }
        return null;
    }

        @Data
        class WangXiangDong{
            private String name;
            private String age;
            private List<String> ids;
        }

        @Test
        public void test001(){
            WangXiangDong wangXiangDong = new WangXiangDong();
            wangXiangDong.setAge("A");
            wangXiangDong.setName("王祥栋");
            Field[] declaredFields = wangXiangDong.getClass().getDeclaredFields();
            for (Field field:
                 declaredFields) {
                String name = field.getName();
                System.out.println(name);
            }
        }

    /**
     * 方法1，求两个集合的交集
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static List<String> intersectionForList_1(List<String> arr1, List<String> arr2) {
        List<String> result = new ArrayList<>();
        for (String arr : arr1) {
            if (arr2.contains(arr)) {
                result.add(arr);
            }
        }
        return result;
    }
    @Test
    public void test0016(){
        BigDecimal subtract = new BigDecimal("100").subtract(null);
        System.out.println(subtract);
    }
@Data
class StudentWXD{
    private String name;
    private String createTime;
}
@Data
class StudentDemo{
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
}
