package com.example.req;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/6/3
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class CheckVisitInfoData {
    /**
     * 检查状态。
     */
    private Boolean checkState;

    /**
     * 检查列表。
     */
    private List<CheckListItem> checkList;
}
