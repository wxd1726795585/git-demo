package com.example.utils;

import com.example.base.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


/**
 * redis lock 1.5
 *
 * @author cuking
 * @version 1.5
 * @date 2017/11/7
 */
@Slf4j
@Component
public class RedisLock {

    private static final int EXPIRE = 35000;
    private static final long TIME_OUT = 30000;

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private static final String UNLOCK_LUA;

    static {
        UNLOCK_LUA = "if redis.call(\"get\",KEYS[1]) == ARGV[1] " +
                "then " +
                "    return redis.call(\"del\",KEYS[1]) " +
                "else " +
                "    return 0 " +
                "end ";
    }

    /**
     * 加锁
     *
     * @param key     锁的name
     * @param val     锁的唯一标识
     * @param timeout 尝试加锁超时时间 毫秒
     * @param expire  锁过期时间 毫秒
     */
    public String lock(String key, String val, long timeout, long expire) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < timeout) {
            if (System.currentTimeMillis() - start > 20000) {
                log.error("加锁超过20S key:{}", key);
            }
            //判断是否为锁定的资源
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            if (stringStringValueOperations.setIfAbsent(key, val, expire, TimeUnit.MILLISECONDS)) {
                log.info("加锁成功 key:{},val:{}", key, val);
                return val;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new BusinessException("异常");
            }
        }
        log.error("加锁超时[{}] key:{}", timeout, key);
        throw new BusinessException("加锁超时");
    }

    /**
     * 加锁
     *
     * @param key 锁的唯一标识
     */
    public String lock(String key) {
        return lock(key, "L" +Math.random(), TIME_OUT, EXPIRE);
    }

    /**
     * 解锁
     *
     * @param key 锁的名称
     * @param val 锁的唯一值
     */
    public boolean unlock(String key, String val) {
        if (null == val) {
            log.error("val为null");
            return false;
        }
        // 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
        try {
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
            redisScript.setScriptText(UNLOCK_LUA);
            redisScript.setResultType(Long.class);
            Long result = stringRedisTemplate.execute(redisScript, Collections.singletonList(key), val);
            boolean b = null != result && result > 0;
            if (b) {
                log.info("解锁成功 key:{},val:{}", key, val);
            } else {
                log.info("解锁失败 key:{},val:{}", key, val);
            }
            return b;
        } catch (Exception e) {
            log.error("解锁失败:", e);
            return false;
        }
    }

    /**
     * 加锁
     *
     * @param key 锁的唯一标识
     */
    public String lock(String key, long timeout, long expire) {
        return lock(key, "L" + Math.random(), timeout, expire);
    }

}
