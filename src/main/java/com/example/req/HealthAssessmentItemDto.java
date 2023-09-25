package com.example.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "测评项名称不能为空")
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
