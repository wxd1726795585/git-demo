package com.example.res;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangshengchao on 2023/10/19
 * @desc 医药项目审核中心-任务审核列表--返回值
 */
@Data
public class CmsImsMissionSubmitRecordListRes implements Serializable {
    /**
     * 任务编号
     */
    private String id;
    /**
     * 任务状态
     */
    private Integer approveStatus;
    /**
     * 任务详情
     */
    private String approveOpinion;
    /**
     * 任务类型
     */
    private Integer missionType;
    /**
     * 服务商姓名
     */
    private String mrName;
    /**
     * 手机号
     */
    private String mrMobile;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 项目编号
     */
    private String projectId;
    /**
     * 提交时间
     */
    private Date submitTime;
    /**
     * 省份
     */
    private String mrProvince;
    /**
     * 区域
     */
    private String mrRegion;
    /**
     * 关联产品
     */
    private String productId;
    private String productName;
    /**
     * 最后审核时间
     */
    private Date auditTime;
    /**
     * 审核人
     */
    private String auditorId;
    private String auditorName;

    /**
     * 所属大区
     */
    private String areaId;
    private String areaName;

    /**
     * 所属事业部
     */
    private String businessUnitId;
    private String businessUnitName;

    /**
     * 代理商姓名
     */
    private String agentName;
}
