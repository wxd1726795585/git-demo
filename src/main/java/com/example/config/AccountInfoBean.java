package com.example.config;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2023/1/9
 * \* Description: 充值信息
 * \* @author 王祥栋
 */
@Data
public class AccountInfoBean {
    /**
     * 收款账户名称
     */
    private String receiverAccountName;
    /**
     * 收款账号
     */
    private String receiverAccountNo;
    /**
     * 开户行
     */
    private String receiverBankBranchName;
}
