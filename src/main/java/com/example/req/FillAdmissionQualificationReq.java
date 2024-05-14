package com.example.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * \* Created with WXD.
 * \* Date:  2024/4/23
 * \* Description: 填写准入资质请求参数
 * \* @author 王祥栋
 */
@Data
public class FillAdmissionQualificationReq {
    /**
     * 是否是本人
     */
    @NotNull(message = "是否是本人选项不能为空")
    private Boolean self;
    /**
     * 是否是医药公司员工或法定代表人或者股东或者监事或者高管
     */
    @NotNull(message = "是否是医药公司董监高选项不能为空")
    private Boolean pharmaceuticalEmployee;
    /**
     * 是否是国家机关任职公务人员
     */
    @NotNull(message = "是否是国家机关任职公务人员选项不能为空")
    private Boolean governmentOfficial;
    /**
     * 是否能遵守平台对于合规和反商业贿赂的要求
     */
    @NotNull(message = "是否能遵守平台对于合规和反商业贿赂的要求选项不能为空")
    private Boolean compliance;
    /**
     * 是否有医药领域工作经验
     */
    @NotNull(message = "是否有医药领域工作经验选项不能为空")
    private Integer pharmaceuticalExperience;
    /**
     * 目前可以参与项目的区域
     */
    @NotBlank(message = "目前可以参与项目的区域选项不能为空")
    private String projectRegion;
    /**
     * 服务商ID
     */
    private String id;
    /**
     * 服务商手机号
     */
    private String mrMobile;
    /**
     * 服务商证件号码
     */
    private String mrIdentNo;
    /**
     * 服务商姓名
     */
    private String mrName;
}
