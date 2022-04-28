package com.example;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/4/19
 * \* Description:保险请求体
 * \* @author 王祥栋
 */
@Data
public class RiderReq {
    /**
     * 承保方案组号(存在代表更新，不存在代表新增)
     */
    private String riderId;
    /**
     * 承保方案组号
     */
    private String policyNo;
    /**
     * 站点编号(必填)
     */
    private String sourceNo;
    /**
     * 骑手身份证号码(必填)
     */
    private String identityCard;
    /**
     * 骑手名称(必填)
     */
    private String riderName;
    /**
     * #操作类型（1：增加 2：删除）(必填)
     */
    private Integer operationStatus;
    /**
     * #操作类型（1：T+1承保 2：实时承保）(不填默认T+1)
     */
    private Integer opType;

    /**
     * "yyyy-MM-dd HH:mm:ss", #上班时间
     */
    private String officeHours;
    /**
     * "yyyy-MM-dd HH:mm:ss" #下班时间
     */
    private String closingTime;

}
