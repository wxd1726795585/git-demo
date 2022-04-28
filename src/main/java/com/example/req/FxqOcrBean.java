package com.example.req;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/28
 * \* Description:放心签增值税OCR识别返回结果
 * \* @author 王祥栋
 */
@Data
@ToString
public class FxqOcrBean {
    /**
     * 发票代码
     */
    private String InvoiceCode;
    /**
     * 发票票号
     */
    private String InvoiceNum;
    /**
     * 开票日期
     */
    private String InvoiceDate;

    /**
     * 开具金额
     */
    private BigDecimal TotalAmount;

    /**
     * 价税合计(小写)
     */
    private BigDecimal AmountInFiguers;
    /**
     * 价税合计(大写)
     */
    private String AmountInWords;

}
