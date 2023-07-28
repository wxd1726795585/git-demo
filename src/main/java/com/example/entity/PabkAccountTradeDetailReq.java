package com.example.entity;

import lombok.Data;

/**
 * @author wuxiaobo
 * @date 2019/7/24 17:54
 */
@Data
public class PabkAccountTradeDetailReq {

    /**
     * 渠道ID
     */
    private String channelId;

    /**
     * 交易日期
     */
    private String bizDate;

}
