package com.example.utils;

import java.math.BigDecimal;

/**
 * @author fuchangshun
 * @date 2019-11-12 16:05
 */
public class AmountUtil {

    /**
     * 分转元 保留两位小数
     *
     * @param pointsValue 分值
     * @return 元值
     */
    public static BigDecimal points2yuan(BigDecimal pointsValue) {
        return pointsValue.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 元转分 保留两位小数
     *
     * @param yuanValue 元值
     * @return 分
     */
    public static BigDecimal yuan2points(BigDecimal yuanValue) {
        return yuanValue.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
