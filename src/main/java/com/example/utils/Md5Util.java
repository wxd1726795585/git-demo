package com.example.utils;

import java.security.MessageDigest;

/**
 * Created by zhaoyixin on 16/10/9.
 */
public class Md5Util {
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

    public static String md5Salt(String s, String salt) {
        return md5(s + salt);
    }

    /**
     * 拼接md5Str
     *
     * @param param
     * @return
     */
    public static String mkMd5Str(String... param) {
        StringBuilder sb = new StringBuilder();
        for (String s : param) {
            sb.append(s);
        }
        return md5(sb.toString()).toLowerCase();
    }
}
