package com.example.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/14
 * \* Description:子项
 */
@Data
public class MeasurementSystemChildBean {
    //计分标准
    private String scoreCriteria;
    //关键字描述
    private String keyWordDesc;
    //起始数值
    private BigDecimal startingValue;
    //结束数值
    private BigDecimal endValue;
}
