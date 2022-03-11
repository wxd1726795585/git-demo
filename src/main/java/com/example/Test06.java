package com.example;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/21
 * \* Description:
 * \* @author 王祥栋
 */
public class Test06 {

    /**
     * 校验数字的正则表达式
     */
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    public static void main(String[] args) {
        String str="1.05565656.5";
        if (checkStrIsNum02(str)&&1==new BigDecimal(str).compareTo(BigDecimal.ZERO)){
            System.out.println("是正数");
        }else {
            System.out.println("不是正数");
        }

    }

    /**
     * 判断是否是正小数
     *
     * @param str
     * @return
     */
    private static boolean isDecimal(String str) {
        if (StringUtils.isBlank(str) || str.contains("-")) {
            return false;
        }

        Pattern pattern = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");
        boolean rst = pattern.matcher(str).matches();

        return rst;
    }

    /**
     * 利用正则表达式来判断字符串是否为数字
     */
    private static boolean checkStrIsNum02(String str) {
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
