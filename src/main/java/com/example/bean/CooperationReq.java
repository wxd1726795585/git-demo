package com.example.bean;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/12
 * \* Description:合规中心请求参数
 * \* @author 王祥栋
 */
@Data
public class CooperationReq {
    /**
     * 行业类别
     */
    private String industryCategory;
    /**
     * 业务覆盖省份
     */
    private List<String> businessCoverageProvinces;
    /**
     * 公司员工数量
     */
    private Integer companyEmployees;
    /**
     * 公司收入规模的起始值
     */
    private String incomeScaleBegin;

    /**
     * 公司收入规模的结束值
     */
    private String incomeScaleEnd;
    /**
     * 公司网址
     */
    private String companyWebSite;
    /**
     * 自由职业者岗位
     */
    private String freelanceJobs;
    /**
     * 场景描述
     */
    private String sceneDesc;

    /**
     * 开票内容
     */
    private String invoiceContent;

    /**
     * 工作地点
     */
    private List<String> workerPlace;

    /**
     *单人单月月收入范围
     */
    private Integer monthIncomeRange;

    /**
     * 自由职业者数量
     */
    private String numberOfFreelancers;

    /**
     *单月总下发额
     */
    private String totalMonthlyPayment;

    /**
     * 费用发放周期
     */
    private String expenseReleaseCycle;

    /**
     * 真实性证明
     */
    private Boolean proofOfAuthenticity;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 更新者
     */
    private String updator;
    /**
     * 商户ID
     */
    private String cooperatorId;
    /**
     * 商户名称
     */
    private String cooperatorName;
}
