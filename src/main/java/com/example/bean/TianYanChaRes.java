package com.example.bean;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/17
 * \* Description:天眼查返回信息
 * \* @author 王祥栋
 */
@Data
public class TianYanChaRes {
    /**
     * 经营信息
     */
    private BusinessInfo businessInfo;
    /**
     * 司法风险
     */
    private LegalRisk legalRisk;
    /**
     * 经营风险
     */
    private ManagementRisk managementRisk;
    /**
     * 合作信息
     */

    private List<CooperativeInfo> list;


}
