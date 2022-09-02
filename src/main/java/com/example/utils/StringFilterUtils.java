package com.example.utils;

/**
 * @author wuxiaobo
 * @date 2019/12/12 10:35
 */
public class StringFilterUtils {

    /**
     * 普通的英文半角空格Unicode编码
     */
    private static final int SPACE_32 = 32;

    /**
     * 中文全角空格Unicode编码(一个中文宽度)
     */
    private static final int SPACE_12288 = 12288;

    /**
     * 普通的英文半角空格但不换行Unicode编码(== &nbsp; == &#xA0; == no-break space)
     */
    private static final int SPACE_160 = 160;

    /**
     * 半个中文宽度(== &ensp; == en空格)
     */
    private static final int SPACE_8194 = 8194;

    /**
     * 一个中文宽度(== &emsp; == em空格)
     */
    private static final int SPACE_8195 = 8195;

    /**
     * 四分之一中文宽度(四分之一em空格)
     */
    private static final int SPACE_8197 = 8197;

    /**
     * 窄空格
     */
    private static final int SPACE_8201 = 8201;

    /**
     * 去除字符串前后的空格, 包括半角空格和全角空格(中文)等各种空格, java的string.trim()只能去英文半角空格
     *
     * @param str
     */
    public static String trim(String str) {
        char[] val = str.toCharArray();
        int st = 0;
        int len = val.length;
        while ((st < len) && isSpace(val[st])) {
            st++;
        }
        while ((st < len) && isSpace(val[len - 1])) {
            len--;
        }
        String result = ((st > 0) || (len < val.length)) ? str.substring(st, len) : str;
        return result.replaceAll("\\s", "");
    }

    private static boolean isSpace(char aChar) {
        return aChar == SPACE_32 || aChar == SPACE_12288 || aChar == SPACE_160 || aChar == SPACE_8194
                || aChar == SPACE_8195 || aChar == SPACE_8197 || aChar == SPACE_8201;
    }


}
