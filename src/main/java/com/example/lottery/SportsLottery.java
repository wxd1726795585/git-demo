package com.example.lottery;

import com.example.utils.Md5Util;
import lombok.Data;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * \* Created with WXD.
 * \* Date:  2024/4/13
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class SportsLottery {
    private boolean flag;
    public static void main(String[] args) {
        SportsLottery sportsLottery = new SportsLottery();
        boolean flag = sportsLottery.isFlag();
        System.out.println(flag);
    }

    public static String maskCompanyName(String companyName) {
        if (companyName == null || companyName.isEmpty()) {
            return companyName;
        }

        int length = companyName.length();
        if (length <= 4) {  // 如果公司名称较短，考虑少量或不脱敏
            return companyName.charAt(0) + "**";  // 只显示第一个字符
        }

        // 常见做法：保留前两个和后两个字符，中间用星号替代
        StringBuilder maskedName = new StringBuilder();
        maskedName.append(companyName.substring(0, 2)); // 保留前两个字符

        for (int i = 2; i < length - 2; i++) {
            maskedName.append('*');
        }

        maskedName.append(companyName.substring(length - 2)); // 保留最后两个字符

        return maskedName.toString();
    }
    public static String maskName(String name) {
        if (StringUtils.isEmpty(name)) {
            return name;
        }
        char[] sArr = name.toCharArray();
        if (sArr.length == 2) {
            return "*" + sArr[1];
        }
        if (sArr.length > 2) {
            for (int i = 1; i < sArr.length - 1; i++) {
                sArr[i] = '*';
            }
            return new String(sArr);
        }
        return name;
    }


    public static String sanitizeString(String input) {
        if (input == null) {
            return null; // 如果输入为空，返回null
        }

        StringBuilder sanitized = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            sanitized.append('*');
        }
        return sanitized.toString();
    }





}
