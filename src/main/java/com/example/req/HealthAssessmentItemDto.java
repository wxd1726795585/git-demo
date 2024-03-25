package com.example.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Jinhao
 * @create 2022/02/28 14:18
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    public String getAssessmentItemName() {
        return assessmentItemName;
    }

    public void setAssessmentItemName(String assessmentItemName) {
        this.assessmentItemName = assessmentItemName;
    }

    public String getBeginScore() {
        return beginScore;
    }

    public void setBeginScore(String beginScore) {
        this.beginScore = beginScore;
    }

    public String getEndScore() {
        return endScore;
    }

    public void setEndScore(String endScore) {
        this.endScore = endScore;
    }
}
