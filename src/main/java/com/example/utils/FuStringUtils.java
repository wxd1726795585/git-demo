package com.example.utils;

/**
 * @author fuchangshun
 * @date 2020/3/24 17:13
 */
public class FuStringUtils {

    public static final String
            PRE_FULL_WIDTH = "（",
            PRE_HALF_WIDTH = "(",
            SUF_FULL_WIDTH = "）",
            SUF_HALF_WIDTH = ")";


    /**
     * 全角转半角
     *
     * @param str 字符串
     * @return 转换后的字符串
     */
    public static String fullWidth2Half(String str) {
        return str.replaceAll(PRE_FULL_WIDTH, PRE_HALF_WIDTH).replaceAll(SUF_FULL_WIDTH, SUF_HALF_WIDTH);
    }


    /**
     * 半角转全角
     *
     * @param preStr 字符串
     * @return 转换后的字符串
     */
    public static String halfWidth2Full(String preStr) {
        return preStr.replaceAll("\\" + PRE_HALF_WIDTH, PRE_FULL_WIDTH).replaceAll("\\" + SUF_HALF_WIDTH, SUF_FULL_WIDTH);
    }

}
