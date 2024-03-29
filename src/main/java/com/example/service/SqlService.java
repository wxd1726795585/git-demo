package com.example.service;

import com.example.HygResponse;
import com.example.entity.CopyEntity;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/6
 * \* Description:
 * \* @author 王祥栋
 */
public interface SqlService {
    /**
     * 测试sql
     *
     * @param flag 标记
     */
    List<CopyEntity> test01Sql(Boolean flag);

    /**
     * 测试sql---v2
     *
     * @return
     */
    HygResponse test02Sql();

    HygResponse test03Sql(String id);

    /**
     * 测试sql---v4
     *
     * @param id
     * @return
     */
    HygResponse test04Sql(String id);

    HygResponse test05Sql(String id);

    /**
     * 测试sql---v6
     *
     * @return
     */
    HygResponse test06Sql();

    HygResponse test07Sql(String cooperatorId);
}
