package com.example.req;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Liuruizhi
 * @date 2019/11/14 下午1:58
 */
@Data
public class InvoiceApprovalReq implements Serializable {
    private static final long serialVersionUID = -4790204286182335583L;

    /**
     * 商户ID
     */
    @NotBlank(message = "商户ID不能为空")
    private String cooperatorId;
    /**
     * 商户名称
     */
    @NotBlank(message = "商户名称不能为空")
    private String cooperatorName;
    /**
     * 开票类目
     */
    @NotBlank(message = "开票类目不能为空")
    private String invoiceVariety;
    /**
     * 开票内容
     */
    @NotBlank(message = "开票内容不能为空")
    private String invoiceContent;
    /**
     * 开票金额
     */
    @NotNull(message = "开票金额不能为空")
    @DecimalMin(value = "0", message = "开票金额不能为负数")
    @DecimalMax(value = "100000000000", message = "开票金额最大不超过100,000,000,000分")
    private BigDecimal invoiceMoney;
    /**
     * 收件人
     */
    @NotBlank(message = "收件人不能为空")
    private String recipientsName;
    /**
     * 收件人电话
     */
    @NotBlank(message = "收件人电话不能为空")
    private String recipientsPhoneNo;
    /**
     * 收件人地址
     */
    @NotBlank(message = "收件人地址不能为空")
    private String recipientsLocation;

    /**
     * 申请发票模式 （batch：批次，rechargeRecords：充值记录）
     */
    @NotBlank(message = "申请模式不能为空")
    private String approvalInvoiceMode;
    /**
     * 发票类型
     */
    @NotNull(message = "发票类型不能为空")
    private Integer invoiceKind;
    /**
     * 下发公司
     */
    @NotBlank(message = "下发公司不能为空")
    private String distributeCompany;
    /**
     * 钉钉审批表主键ID
     */
    @NotBlank(message = "发票申请ID不能为空")
    private String invoiceApprovalId;
    //税务信息
    /**
     * 税务登记号
     */
    @NotBlank(message = "税务登记号不能为空")
    private String taxId;
    /**
     * 电话
     */
    @NotBlank(message = "企业电话不能为空")
    private String taxPhoneNo;
    /**
     * 公司地址
     */
    @NotBlank(message = "企业地址不能为空")
    private String companyLocation;
    /**
     * 开户行
     */
    @NotBlank(message = "企业开户行名称不能为空")
    private String openingBank;
    /**
     * 开户账号
     */
    @NotBlank(message = "企业开户行卡号不能为空")
    private String openingAccount;

    //以下参数为批次开票时使用
    /**
     * 寄件人地址
     */
    @NotBlank(message = "寄件人地址不能为空")
    private String senderAddress;
    /**
     * 寄件人电话
     */
    @NotBlank(message = "寄件人电话不能为空")
    private String senderMobile;
    /**
     * 寄件人名称
     */
    @NotBlank(message = "寄件人不能为空")
    private String senderName;
    /**
     * 业务负责人ID
     */
    @NotBlank(message = "业务负责人不能为空")
    private String businessManagerId;
    /**
     * 发票申请记录关联神物名称；逗号分隔
     */
    private String correlationPositionName;
    /**
     * 备注
     */
    private String remark;

}
