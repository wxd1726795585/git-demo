package com.example.res;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/4/22
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class RiderInfo {
    /**
     * 骑手ID
     */
    private String riderId;
    /**
     * 承保方案组号
     */
    private String policyNo;
    /**
     * 站点编号
     */
    private String sourceNo;
    /**
     * 骑手身份证号码
     */
    private String identityCard;
    /**
     * 骑手名称
     */
    private String riderName;

    /**
     * 操作类型(1.增加 2.删除)
     */
    private Integer operationStatus;
    /**
     * 备注
     */
    private String remark;
    /**
     * 上班时间
     */
    private String officeHours;
    /**
     * 下班时间
     */
    private String closingTime;
}
