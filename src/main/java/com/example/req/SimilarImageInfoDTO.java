package com.example.req;

import lombok.Data;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2024/5/27
 * \* Description: 相似图片信息
 * \* @author 王祥栋
 */
@Data
public class SimilarImageInfoDTO {
    /**
     * 图片地址
     */
    private String url;
    /**
     * 图片相似度分数
     */
    private BigDecimal similarity = BigDecimal.ZERO;
}
