package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/14
 * \* Description:健康测评系统配置枚举
 * \* @author 王祥栋
 */
@Getter
@AllArgsConstructor
public enum MeasurementSystemConfEnum {
    MIN_GAN_HANG_YE("敏感行业",1,0,false,"sensitiveIndust"),
    JING_YING_FENG_XIAN("经营风险",0,-1,false,"managementRisk"),
    HE_TONG_GUI_DANG("合同归档",0,-1,false,"contractFiling"),
    QI_TA_XIN_XI("其他信息",0,-1,false,"otherInfo"),
    ZHENG_JIAN_ZHAO("证件照",1,1,false,"profilePicture"),
    ZHEN_SHI_SHOU_JI_HAO("真实手机号",1,1,false,"realPhoneNum"),
    JING_MO_QIAN_YUE("静默签约",1,1,false,"silentSign"),
    DIAN_ZI_HUI_DAN("电子回单",1,1,false,"digitalReceipt"),
    XIA_GUA_MO_SHI("下挂模式",-1,-1,false,"underMode"),
    PING_JUN_XIA_FA("平均下发额",1,1,false,"averageDelivery"),
    DA_E_XIA_FA("大额下发",1,1,false,"largeDistributed"),
    SHANG_SHI_QI_YE("上市企业",-1,-1,true,"listedCompanies"),
    TOP_WU_BAI_CHINA("中国500强",-1,-1,true,"chineseTop"),
    TOP_WU_BAI("世界500强",-1,-1,true,"worldTop"),
    GUO_YOU_QI_YE("国有企业",-1,-1,true,"stateEnterprises"),
    CHI_XU_HE_ZUO("持续合作企业",-1,0,true,"continuedCompanies"),
    JI_PEI_HANG_YE("即配行业",-1,-1,true,"deliveryIndustry"),
    TOU_BAO_SHANG_HU("投保商户",-1,-1,true,"insuredCooperator"),
    YUE_PING_JUN_LIANG("月平均产量",1,1,true,"averageMonthOutput"),
    QI_TA_ZENG_YI("其他增益",1,1,true,"otherGain");


    /**
     * 测评项目
     */
    private String assessmentItem;
    /**
     * 计分规则(1则取最高分 0则代表累计 -1没有规则说明就一项)
     */
    private Integer pointDeductionRules;
    /**
     * 1代表区间 0代表单格 -1代表无需填值
     */
    private Integer intervalOrNot;
    /**
     * 加分还是减分(true加分false为减分)
     */
    private Boolean addOrSubPoints;
    /**
     * 封装返回类型
     */
    private String packType;

    public static MeasurementSystemConfEnum getRulesEnum(String assessmentItem){
        for (MeasurementSystemConfEnum measurementSystemConfEnum:
        MeasurementSystemConfEnum.values()) {
            if (measurementSystemConfEnum.getAssessmentItem().equals(assessmentItem)){
                return measurementSystemConfEnum;
            }
        }
        return null;
    }
}
