package com.example.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yangshengchao on 2023/11/21
 * @desc 任务具体详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionSubmitRecordDetailVo {
    /**
     * 任务编码
     */
    private String id;

    /**
     * 审核成功的下发金额
     */
    private BigDecimal distributeAmount;
    /**
     * 任务定价
     */
    private BigDecimal missionUnitPrice;
    /**
     * 人次
     */
    private Integer personTime;
    /**
     * 所在区域
     */
    private String provinceCity;
    /**
     * 任务具体内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
}
