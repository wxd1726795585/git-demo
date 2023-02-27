package com.example.enums;

import com.example.base.BusinessException;
import lombok.Getter;
import lombok.ToString;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/24
 * \* Description: 测试枚举
 * \* @author 王祥栋
 */
@Getter
@ToString
public enum DemoState {
    CHU_SHI_STATE(1, "初始状态"),
    ZHONG_JIAN_STATE(2, "中间状态"),
    ;

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 状态码描述
     */
    private final String codeDesc;

    private DemoState(Integer code, String codeDesc) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public static DemoState parse(Integer code) {
        for (DemoState demoState :
                DemoState.values()) {
            if (code.equals(demoState.getCode())) {
                return demoState;
            }
        }
        throw new BusinessException("为找到对应的状态");
    }
}
