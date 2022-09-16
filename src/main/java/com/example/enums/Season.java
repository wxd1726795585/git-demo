package com.example.enums;

import com.example.base.BusinessException;
import lombok.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.util.CollectionUtils;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/13
 * \* Description:季节的枚举
 * \* @author 王祥栋
 */
@Getter
@AllArgsConstructor
@ToString
public enum Season {
    SPRING("春天", 1),
    SUMMER("夏天", 2),
    AUTUMN("秋天", 3),
    WINTER("冬天", 4);
    private final String name;
    private final Integer code;

    /**
     * 解析枚举
     *
     * @param code
     * @return
     */
    public static Season parse(int code) {
        Season[] values = Season.values();
        for (Season season :
                values) {
            if (season.getCode().equals(code)) {
                return season;
            }
        }
        throw new BusinessException("没找到对应枚举类型,解析失败");
    }
}
