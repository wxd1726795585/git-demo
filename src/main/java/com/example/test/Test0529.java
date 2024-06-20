package com.example.test;

import com.example.enums.CheckVisitTypeEnum;
import com.example.req.CheckListItem;
import com.example.req.MimsUploadMrPictureDTO;
import com.example.req.SimilarImageInfoDTO;
import com.example.res.CmsImsMissionSubmitRecordListRes;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2024/5/29
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0529 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        Collection<String> values = map.values();
        System.out.println(values);

    }

    public static void test006(Integer integer){
        integer= integer+1;
    }

}
