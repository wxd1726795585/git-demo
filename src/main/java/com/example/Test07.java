package com.example;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/24
 * \* Description:
 * \* @author 王祥栋
 */
public class Test07 {

    /**
     * 校验数字的正则表达式
     */
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        String format = Test07.format.format(date);
        format = format.concat(" 00:00:00");

        System.out.println(format);

    }


    @Test
    public void demo001() {
        String identNo = "14272919980304511X";
        Integer age = 0;
        Date date = new Date();
        if (identNo.length() == 18) {
            // 身份证上的年份
            String year = identNo.substring(6).substring(0, 4);
            System.out.println(year);
            String format = Test07.format.format(new Date());
            System.out.println(format);
            age = Integer.valueOf(format) - Integer.valueOf(year);
        } else {
            //不是18位数的身份证号码,默认25岁
            age = 25;
        }
        System.out.println(age);
    }

    /**
     * 利用正则表达式来判断字符串是否为数字
     */
    private static boolean checkStrIsNum02(String str) {
        if (str.contains("-")) {
            return false;
        }
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

}
