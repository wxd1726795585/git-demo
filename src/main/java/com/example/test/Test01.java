package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/2
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class Test01 {
    public static void main(String[] args) {
        /*
         * 升景坊单间短期出租4个月，550元/月（水电煤公摊，网费35元/月），空调、卫生间、厨房齐全。
         * 屋内均是IT行业人士，喜欢安静。所以要求来租者最好是同行或者刚毕业的年轻人，爱干净、安静。
         */
        try {
            int i =1/0;
        }catch (Exception e){
            log.info("异常:",e);
        }
    }


}
@ToString
@AllArgsConstructor
class A {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
