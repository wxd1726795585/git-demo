package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * \* Created with WXD.
 * \* Date:  2024/6/4
 * \* Description: 检查拜访类别枚举
 * \* @author 王祥栋
 */
@Getter
@AllArgsConstructor
public enum CheckVisitTypeEnum {
    /**
     * 门店名称
     */
    SHOP_NAME(1, "门店名称"),
    /**
     * 门店地址
     */
    SHOP_ADDRESS(2, "门店地址"),
    /**
     * 日期
     */
    DATE(3, "日期"),
    /**
     * 时间段
     */
    TIME_PERIOD(4, "时间段");

    private final Integer type;
    private final String desc;

}
