package com.example.impl;

import com.example.service.AllKindsTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/2
 * \* Description:
 * \* @author 王祥栋
 */
@Service
@Slf4j
public class AllKindsTestServiceImpl implements AllKindsTestService {

    @Override
    public void asyncTest() {
        try {
            log.info("测试异步");
            this.testAsync();
            System.out.println("结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    @Override
    public void testAsync() {
        try {
            log.info("睡眠10S");
            Thread.sleep(10000L);
            log.info("睡眠结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
