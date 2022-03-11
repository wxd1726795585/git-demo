package com.example.req;

import com.example.bean.HuaRuiYunResultBean;
import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date: 2021/11/11
 * \* Description:华瑞云短信返回参数信息
 */
@Data
public class HuaRuiYunSmsReq {
    //返回码
    private String code;
    //返回码描述
    private String desc;
    //提交返回的唯一标识（32位字符串，用于获取短信回执）
    private String uid;
    //提交短信的详细状态数据
    private HuaRuiYunResultBean[] result;
}
