package com.example.test;

import com.example.req.MissionSubmitRecordDetailVo;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with WXD.
 * \* Date:  2024/5/6
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0506 {
    public static void main(String[] args) {
        // 创建一些示例数据
        List<MissionSubmitRecordDetailVo> missionList = new ArrayList<>();
        missionList.add(new MissionSubmitRecordDetailVo("1", new BigDecimal("100"), new BigDecimal("10"), 5, "RegionA", "ContentA", new Date(16980480010000L))); // 2023-11-21 10:00:00
        missionList.add(new MissionSubmitRecordDetailVo("2", new BigDecimal("200"), new BigDecimal("20"), 10, "RegionB", "ContentB", new Date(1698051600000L))); // 2023-11-21 11:00:00
        missionList.add(new MissionSubmitRecordDetailVo("3", new BigDecimal("150"), new BigDecimal("15"), 7, "RegionC", "ContentC", new Date(1698044400000L))); // 2023-11-21 09:00:00
        // 移除 createTime 最大的一条数据
        removeMaxCreateTimeRecord(missionList);

        // 打印结果
        missionList.forEach(System.out::println);
    }

    public static void removeMaxCreateTimeRecord(List<MissionSubmitRecordDetailVo> missionList) {
        if (missionList == null || missionList.isEmpty()) {
            return;
        }

        // 找到 createTime 最大的对象
        Optional<MissionSubmitRecordDetailVo> maxRecordOpt = missionList.stream()
                .max(Comparator.comparing(MissionSubmitRecordDetailVo::getCreateTime));

        // 如果找到了最大值对象，则移除它
        maxRecordOpt.ifPresent(missionList::remove);
    }
}

