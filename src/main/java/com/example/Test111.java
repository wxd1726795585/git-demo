package com.example;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/9
 * \* Description:
 * \* @author 王祥栋
 */
@SpringBootTest
public class Test111 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {

    }
    @Test
    public void test001(){
        ArrayList<Test888> test888s = new ArrayList<>();
        test888s.add(new Test888("张三",15));
        test888s.add(new Test888("李四",15));
        test888s.add(new Test888("王五",15));
        test888s.add(new Test888("赵六",15));
        test888s.add(new Test888("王铁但",16));
        String s = JSON.toJSONString(test888s,true);
        System.out.println(s);

    }
}
@Data
@AllArgsConstructor
class Test666{
    private String name;
    private Integer age;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Test888{
    private String name;
    private Integer age;
}

