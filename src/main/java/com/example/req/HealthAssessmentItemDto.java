package com.example.req;

import lombok.Data;

/**
 * @author Jinhao
 * @create 2022/02/28 14:18
 * @description
 */
@Data
public class HealthAssessmentItemDto {
    /**
     * 测评项名称
     */
    private String assessmentItemName;

    /**
     * 起始分值
     */
    private String beginScore;

    /**
     * 结束分值
     */
    private String endScore;
}
