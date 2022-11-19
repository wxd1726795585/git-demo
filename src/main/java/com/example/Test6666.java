package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * \* Created with WXD.
 * \* Date:  2022/6/7
 * \* Description:测试
 * \* @author 王祥栋
 */
@Data
public class Test6666 {
    private final static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static void main(String[] args) throws ParseException {

        Studentx studentx = new Studentx("王祥栋", "xxx");
        Studentx1 studentx1 = new Studentx1();
        BeanUtils.copyProperties(studentx,studentx1);
        System.out.println(studentx1);
    }
    /**
     * 生成18位随机时间戳
     *
     * @return
     */
    public static String dateRandom16() {

        //获取当前年月日
        String date = yyyyMMdd.format(new Date());

        //获取时间戳后6位
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String fiveNumber = timeMillis.substring(timeMillis.length() - 6);

        //获取随机数后4位
        String tempRandom = String.valueOf(Math.random());
        String number = tempRandom.substring(tempRandom.length() - 4);

        //生成18位随机时间戳数字
        return date + fiveNumber + number;
    }


}
@Data
@AllArgsConstructor
class Studentx{
    private String name;
    private String idCard;
}
@Data
class Studentx1{
    private String name;
    private String idCard;
}
