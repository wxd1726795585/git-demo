package com.example.bean;

import lombok.Data;

import java.math.BigDecimal;

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
    private BigDecimal age;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 住址
     */
    private String address;
}
