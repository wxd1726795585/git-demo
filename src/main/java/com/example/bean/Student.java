package com.example.bean;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/2
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 住址
     */
    private String address;
}
