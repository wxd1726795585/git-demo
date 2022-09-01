package com.example;

import com.example.service.TestExpression;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Test66666 test66666 = new Test66666();
        test66666.setAge("16");
        test66666.setName("王祥栋");
        Test77777 test77777 = new Test77777();
        BeanUtils.copyProperties(test66666,test77777);
        System.out.println(test77777);
    }

    /**
     * 测试方法
     * @param i
     * @param y
     */
    public static void test(int i,int y){
        System.out.println("测试方法");
    }
    @Test
    public void test001(){
        try {

            // 使用基本编码
            String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

            // 解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
            base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

        }catch(UnsupportedEncodingException e){
            System.out.println("Error :" + e.getMessage());
        }

    }
    @Test
    public void demo006(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");
        strings.add("11");
        strings.add("12");
        Map map = groupList(strings);
        System.out.println(map);
    }

    /**
     *
     * @param list
     * @return map
     */
    public Map groupList(List<String> list){
        //listSize为集合长度
        int listSize=list.size();
        //每次取1000条
        int index=10;
        int keyToken = 0;
        //用map存起来新的分组后数据
        Map map = new HashMap();
        for(int i = 0;i<list.size();i+=10){
            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
            if(i+10>listSize){
                index=listSize-i;
            }
            //使用subList方法，keyToken用来记录循环了多少次或者每个map数据的键值
            List newList = list.subList(i,i+index);
            //每取一次放到map集合里，然后
            map.put("keyName"+keyToken, newList);
            keyToken++;
        }
        return map;
    }

}
@Data
class Test66666{
    private String name;
    private String age;
}
@Data
class Test77777{
    private String name;
    private String age;
}