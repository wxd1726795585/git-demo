package com.example;

import com.example.collect.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/21
 * \* Description:
 * \* @author 王祥栋
 */
public class Test06 implements Callable {


    /**
     * 校验数字的正则表达式
     */
    private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test06 test06 = new Test06();
        FutureTask futureTask = new FutureTask<>(test06);
        Thread thread = new Thread(futureTask);
        thread.start();
        Object o = futureTask.get();
        System.out.println(o);
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
    @Test
    public void test(){
        Date date = new Date();
        String s = DateUtils.dateToString(date, 1);
        String s1 = DateUtils.dateToString(date, 2);
        System.out.println(s);
        System.out.println(s1);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"启动子线程");
        return 1;
    }
}
