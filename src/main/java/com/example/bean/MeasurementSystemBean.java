package com.example.bean;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/14
 * \* Description:
 */
@Data
public class MeasurementSystemBean {
    //测评项
    private String assessmentItem;
    //扣分规则
    private Integer pointDeductionRules;
    //子项
    private List<MeasurementSystemChildBean> list;

}
