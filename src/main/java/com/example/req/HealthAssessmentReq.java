package com.example.req;

import lombok.Data;

import java.util.List;

/**
 * @author Jinhao
 * @create 2022/02/28 14:06
 * @description
 */
@Data
public class HealthAssessmentReq {
    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 测评时间起始值
     */
    private String beginTime;

    /**
     * 测评时间结束值
     */
    private String endTime;

    /**
     * 总分起始值
     */
    private String beginTotalScore;

    /**
     * 总分结束值
     */
    private String endTotalScore;

    /**
     * 测评项（名称+起始、结束分值）
     */
    private String assessmentItemList;

    /**
     * 排序规则项
     */
    private String sortItem;

    /**
     * 排序关键字
     */
    private String sortWord;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 分页大小
     */
    private Integer pageSize;
}
