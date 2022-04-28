package com.example;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/4/19
 * \* Description:请求来源
 * \* @author 王祥栋
 */
@Data
public class RequestSource {
    /**
     * 来源渠道
     */
    private String from;
    /**
     * 请求类型，数据字典（riderOperate：骑手增减操作  ， queryRiderInfo：查询，riderDelete：删除未参保骑手信息）
     */
    private String requestType;
    /**
     * 签名参数  #签名 bodyStr + sourceNo（站点编号） + account（账号）+ passwords（密码）的MD5加密
     */
    private String sign;

}
