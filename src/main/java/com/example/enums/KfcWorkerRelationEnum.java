package com.example.enums;

import com.example.base.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yangshengchao on 2023/4/18
 * @desc KFC-人员关系
 */
@Getter
@AllArgsConstructor
public enum KfcWorkerRelationEnum {
    //----------------
    zzzzz(0, "父母"),
    RELATION_1(1, "配偶"),
    RELATION_2(2, "子女"),
    RELATION_3(3, "兄妹"),
    RELATION_4(4, "兄弟"),
    RELATION_5(5, "叔伯"),
    RELATION_6(6, "同事"),
    RELATION_7(7, "朋友"),
    RELATION_8(8, "其他"),
    ;

    private final int key;
    private String value;

    public static KfcWorkerRelationEnum parse(int key) {
        for (KfcWorkerRelationEnum value : values()) {
            if (value.getKey() == key) {
                return value;
            }
        }
        throw new BusinessException("状态码解析异常");
    }
}
