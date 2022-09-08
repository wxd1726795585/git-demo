package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * \* Created with WXD.
 * \* Date:  2022/7/7
 * \* Description:
 * \* @author 王祥栋
 */
public class TestDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        TreeSet<Object> objects = new TreeSet<>();
        objects.add("aaa");
        objects.add("bbb");
        //objects.add(111);
        boolean aaa = objects.contains("aaa");
        System.out.println(aaa);
    }
    @Test
    public static void redis(){

    }
}
