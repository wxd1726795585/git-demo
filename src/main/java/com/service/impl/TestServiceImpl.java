package com.service.impl;

import com.example.utils.RedisLock;
import com.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/11
 * \* Description:
 * \* @author 王祥栋
 */
@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private RedisLock redisLock;
    public static String REDIS_LOCK="REDIS_LOCK";
    @Override
    public void demo01() {
        BigDecimal bigDecimal = new BigDecimal("2");
    }

    @Override
    @Async
    public void demo07(String name) {
        String lockKey=REDIS_LOCK+name;
        String lockVal=null;
        try {
            lockVal=redisLock.lock(lockKey,"L"+Math.random(),30000L,240000L);
            log.info("1111111111111111111");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock(lockKey,lockVal);
        }
    }
}
