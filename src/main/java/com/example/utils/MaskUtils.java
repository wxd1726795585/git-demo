package com.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.TextUtils;

/**
 * @author ; lidongdong
 * @Description 邮箱 身份证 手机号脱敏
 * @Date 2019-12-16
 */
public class MaskUtils {


    private MaskUtils() {
    }

    /**
     * 名字脱敏
     * 规则，张三丰，脱敏为：张*丰
     *
     * @param name 姓名
     * @return String
     */
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

    /**
     * 隐藏手机号 155****7649
     *
     * @param mobile
     * @return
     */
    public static String maskMobile(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 隐藏邮箱信息 coup***@sina.com
     *
     * @param email
     * @return
     */
    public static String maskEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return email;
        }
        return email.replaceAll("(\\w+)\\w{3}@(\\w+)", "$1***@$2");
    }

    /**
     * 隐藏身份证号码 362201******191811
     *
     * @return
     */
    public static String maskIdCardNo(String idCardNum) {
        if (TextUtils.isEmpty(idCardNum)) {
            return "";
        }
        if (idCardNum.length() < 18) {
            //计算需要隐藏的开始和结束位置 不是
            int index = getIndex(idCardNum);
            return hideIdNumber(idCardNum, index, index);
        }
        return hideIdNumber(idCardNum, 3, 4);
    }


    public static int getIndex(String idCardNum) {
        return idCardNum.length() / 3;
    }


    /**
     * 用户身份证号码的打码隐藏加星号加*
     * <p>18位和非18位身份证处理均可成功处理</p>
     * <p>参数异常直接返回null</p>
     *
     * @param idCardNum 身份证号码
     * @param front     需要显示前几位
     * @param end       需要显示末几位
     * @return 处理完成的身份证
     */
    public static String hideIdNumber(String idCardNum, int front, int end) {
        //身份证不能为空
        if (TextUtils.isEmpty(idCardNum)) {
            return "";
        }
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) {
            return "";
        }
        //需要截取的不能小于0
        if (front < 0 || end < 0) {
            return "";
        }
        //计算*的数量
        int asteriskCount = idCardNum.length() - (front + end);
        StringBuffer asteriskStr = new StringBuffer();
        for (int i = 0; i < asteriskCount; i++) {
            asteriskStr.append("*");
        }
        String regex = "(\\w{" + String.valueOf(front) + "})(\\w+)(\\w{" + String.valueOf(end) + "})";
        return idCardNum.replaceAll(regex, "$1" + asteriskStr + "$3");
    }


    /**
     * [银行卡号] 前六位，后四位，其他用星号隐藏每位1个星号<例子:622848*********5616>
     *
     * @param cardNum
     * @return
     */
    public static String maskBankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }


    /**
     * [收款账号] 前4位，后4位，其他用星号隐藏每位1个星号<例子:6228*********5616>
     *
     * @param cardNum
     * @return
     */
    public static String maskBankCardAll(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * [公司开户银行联号] 公司开户银行联行号,显示前两位，其他用星号隐藏，每位1个星号<例子:622848*************>
     *
     * @param code
     * @return
     */
    public static String maskCnapsCode(String code) {
        if (StringUtils.isBlank(code)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(code, 6), StringUtils.length(code), "*");
    }

    /**
     * [地址] 只显示到地区，不显示详细地址；我们要对个人信息增强保护<例子：北京市海淀区****>
     *
     * @param address
     * @param sensitiveSize 敏感信息长度
     * @return
     */
    public static String maskAddress(String address, int sensitiveSize) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, length - sensitiveSize), length, "*");
    }



    public static void main(String[] args) {
        System.out.println(MaskUtils.maskAddress("北京市朝阳区酒仙桥路电子科技大厦",9));
//
    }
}
