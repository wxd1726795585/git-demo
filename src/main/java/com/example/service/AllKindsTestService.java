package com.example.service;

import com.example.HygResponse;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/2
 * \* Description:
 * \* @author 王祥栋
 */
public interface AllKindsTestService {
    /**
     * 测试异步
     */
    void asyncTest();

    /**
     * 异步测试
     */
    HygResponse testAsync();

    HygResponse demo01();

}
