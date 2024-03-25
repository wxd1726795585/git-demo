package com.example.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/15
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class TestDemo01 {
    public static void main(String[] args) {
        List<String> randomStringList = Arrays.asList("阿曼vs泰国让负，1-1，0-1","吉尔吉斯斯坦vs沙特负，0-2，0-3","谢菲联vs西汉姆让胜，1-1，1-0","伯恩茅斯vs利物浦让平/让胜，1-2，2-2",
                "弗洛西vs卡利亚里胜，1-0，2-0","莱切vs尤文图斯负，1-2，0-2","奥萨苏纳vs赫塔费胜/平，1-0，1-1","贝蒂斯vs巴塞罗那让平/让胜，1-2，1-1","赫罗纳vs塞维利亚胜/平，2-1，1-1");

        // 随机排列集合
        Collections.shuffle(randomStringList);

        // 选取三组每组两个不同的字符串
        for (int i = 0; i < 6; i += 2) {
            // 获取两个不同的字符串
            String str1 = randomStringList.get(i);
            String str2 = randomStringList.get(i + 1);

            // 打印或处理这两个字符串的组合
            System.out.println("Group: " + str1 + ", " + str2);
        }

        // 再生成一组随机字符串，这一组可以为这八个字符串中的任意两个
        String randomGroupMember1 = getRandomElement(randomStringList);
        String randomGroupMember2 = getRandomElement(randomStringList);

        // 打印或处理这一组随机字符串
        System.out.println("Random Group: " + randomGroupMember1 + ", " + randomGroupMember2);
    }

    // 从列表中随机选择一个元素
    private static String getRandomElement(List<String> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }


    @Test
    public void demo02(){
        B b = new B();
        demo(b);
        System.out.println(JSON.toJSONString(b));
    }

    public void demo(A a){
        a.setAge("222");
        a.setName("222");
    }


}
@Data
class A{
    private String name;
    private String age;
}
@Data
class B extends A{
    private String identNo;
}