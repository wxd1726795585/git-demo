package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * 订单状态
 *
 * @author ; lidongdong
 * @date 2019-11-04
 */
@Getter
@ToString
@AllArgsConstructor
public enum OrderStatus {

    //订单状态
    SUSPEND(-2, "中断"),
    REFUND(-1, "退款"),
    WAIT_PAY(10, "待付款"),
    CANCELED(11, "已取消"),
    WATING(20, "待打款"),
    IN(30, "处理中"),
    ALL_SUCCESS(40, "全部打款成功"),
    PART_SUCCESS(50, "部分打款成功"),
    ALL_FAILED(60, "全部打款失败");

    private final int code;
    private final String desc;

    /**
     * 解析
     *
     * @param code 代码
     * @return {@link OrderStatus}
     */
    public static OrderStatus parse(int code) {
        for (OrderStatus system : OrderStatus.values()) {
            if (code == system.getCode()) {
                return system;
            }
        }
        return null;
    }

    /**
     * 获取处理中的订单状态
     *
     * @return 处理中
     */
    public static List<Integer> getInDealStatus() {
        return Arrays.asList(WAIT_PAY.code, WATING.code, IN.code);
    }
}
