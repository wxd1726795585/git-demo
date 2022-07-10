package com.example.res;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/23
 * \* Description:税务评级
 * \* @author 王祥栋
 */
@Data
public class TaxCreditRes {
    /**
     * 纳税等级
     */
    private String grade;
    /**
     * 年份
     */
    private String year;
    /**
     * 评价单位
     */
    private String evalDepartment;
    /**
     * 类型
     */
    private String type;
    /**
     * 纳税人识别号
     */
    private String idNumber;
    /**
     * 纳税人名称
     */
    private String name;
}
