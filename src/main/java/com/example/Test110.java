package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/8
 * \* Description:
 * \* @author 王祥栋
 */
public class Test110 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {

    }
    @Test
    public void test001(){
        /*Map<Object, Object> name_hash = stringRedisTemplate.opsForHash().entries("NAME_HASH");
        List<String> collect = name_hash.keySet().stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(collect);*/
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }
}
