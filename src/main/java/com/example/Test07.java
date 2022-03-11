package com.example;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        ArrayList<Student002> demo008s = new ArrayList<>();
        demo008s.add(new Student002("张三",1));
        demo008s.add(new Student002("李四a",5));
        demo008s.add(new Student002("王五",2));
        demo008s.add(new Student002("赵六",10));

    }




    /**
     * 利用正则表达式来判断字符串是否为数字
     */
    private static boolean checkStrIsNum02(String str) {
        if (str.contains("-")){
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
