package com.example.bean;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date: 2021/11/11
 * \* Description:华瑞云短信发送结果
 */
@Data
public class HuaRuiYunResultBean {
    //状态码
    private String status;
    //手机号码
    private String phone;
    //状态码描述
    private String desc;
}
