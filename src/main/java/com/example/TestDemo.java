package com.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

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
        Student006 student006 = new Student006();
        student006.setName("a");
        System.out.println(student006.getName());

    }
}
class Student006{
      String name;
      protected Student006(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Student006(int i){

    }
}
