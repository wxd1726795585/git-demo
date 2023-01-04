package com.example;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
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
        String dd="2022-08-01 00:00:00";
        String substring = dd.substring(0, 7);
        System.out.println(substring);
    }
    @Test
    public void test001(){
        HashSet<String> objects = new HashSet<>();
        objects.add("C1034869026196557824.5656565212");
        Set set =new HashSet<>(objects);
        objects.remove("C1034869026196557824.5656565212");
        System.out.println(set);
        System.out.println("objects:"+objects);
    }


    /**
     * 商户是否存在其他数据
     * @param set
     * @return
     */
    private Boolean aditionalDataExistsMerchant(Set<Object> set,String cooperatorIdData){
        String cooperatorId = cooperatorIdData.substring(0, cooperatorIdData.lastIndexOf("."));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String next = (String)iterator.next();
            if (next.equals(cooperatorIdData)){
                iterator.remove();
            }
        }
        for (Object o:
                set) {
            String date =(String)o;
            String otherCooperatorId = date.substring(0, date.lastIndexOf("."));
            if (otherCooperatorId.equals(cooperatorId)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
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
@ToString
class Test888{
    private String name;
    private Integer age;
}

