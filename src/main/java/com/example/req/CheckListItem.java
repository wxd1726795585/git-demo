package com.example.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2024/6/3
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckListItem {
    /**
     * 名称，对应识别的数据。
     */
    private String name;

    /**
     * 类别。
     */
    private String type;

    /**
     * 源值。
     */
    private String originalValue;

    /**
     * OCR识别的值。
     */
    private String ocrValue;

    /**
     * 分数。
     */
    private BigDecimal score;

    /**
     * 最终判断状态。
     */
    private Boolean state;
}
