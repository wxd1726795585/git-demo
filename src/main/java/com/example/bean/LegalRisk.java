package com.example.bean;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/17
 * \* Description:司法风险
 * \* @author 王祥栋
 */
@Data
public class LegalRisk {
    private String legalAction;

    private String legalActionDetail;

    private String historyLegalAction;

    private String personSubjected;

    private String consumptionRestriction;

    private String fileInformation;

}
