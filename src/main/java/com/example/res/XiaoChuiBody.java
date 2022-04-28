package com.example.res;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/4/22
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class XiaoChuiBody {
    /**
     * 成功数量
     */
    private Integer totality;
    private List<RiderInfo> riderArray;
}
