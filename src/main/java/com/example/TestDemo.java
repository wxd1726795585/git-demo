package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * \* Created with WXD.
 * \* Date:  2022/7/7
 * \* Description:
 * \* @author 王祥栋
 */
public class TestDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void redis(){
        /*//联系redis的常用api
        //String类型的
        redisTemplate.opsForValue().set("test0708","test0708");
        System.out.println(redisTemplate.opsForValue().get("test0708"));
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1","1");
        stringStringHashMap.put("2","2");
        redisTemplate.opsForValue().multiSet(stringStringHashMap);*/
        BigDecimal bigDecimal = new BigDecimal("0");
        bigDecimal.add(new BigDecimal("111"));
        System.out.println(bigDecimal);
        String str="aaa";
        str.concat("bbb");
        System.out.println(str);
    }
}
