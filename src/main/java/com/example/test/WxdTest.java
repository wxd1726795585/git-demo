package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * \* Created with WXD.
 * \* Date:  2024/3/25
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@AllArgsConstructor
public class WxdTest {
    private String age;
    private String name;
    public static void main(String[] args) {
        String randomPassword = getRandomPassword(3);
        System.out.println(randomPassword);

    }
    /**
     * 获取随机密码
     *
     * @param len 密码长度
     * @return 指定长度字符串
     */
    public static String getRandomPassword(int len) {
        char[] charArrayA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        char[] charArrayB = "1234567890".toCharArray();

        char[] charArrayC = "~!@#$%&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charArrayA[r.nextInt(charArrayA.length)]);
            sb.append(charArrayB[r.nextInt(charArrayB.length)]);
            sb.append(charArrayC[r.nextInt(charArrayC.length)]);
        }
        return sb.toString();
    }

    public static String md5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
@Data
class WxdTest01{
    private String age;
    private String name;
    private List<WxdInfo> list;
}
@Data
@AllArgsConstructor
class WxdInfo{
    private String idCard;
    private String height;
}
