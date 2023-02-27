package com.example.res;

import lombok.Data;

/**
 * @author caosong
 * @date 2020/6/10 上午10:45
 */
@Data
public class ApiH5SignCallbackRes {


    /**
     * workerId
     */
    private String workerId;
    /**
     * 签约状态
     */
    private String agreeState;

    /**
     * 签约状态描述
     */
    private String agreeDesc;

    /**
     * 手机号
     */
    private String workerMobile;


    /**
     * 回调次数
     */
    private Integer times;

    /**
     * 商户id
     */
    private String cooperatorId;

    /**
     * 商户回调地址
     */
    private String callbackUrl;

    /**
     * 渠道标识——丸美百货得特殊处理
     */
    private String c;


}
