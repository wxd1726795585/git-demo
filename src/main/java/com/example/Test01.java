package com.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/10
 * \* Description:stream练习题
 */
public class Test01 {
    public static final String WORKER_MAX_AGE1 = "尊敬的客户：您好！系统检测到“***\"于本年度累计结算金额已达到175万元，鉴于此人金额较大，请谨慎核实该人员的业务真实性，避免虚开发票和洗钱风险。";
    public static void main(String[] args) {
       /* String replace = WORKER_MAX_AGE1.replace("***", "张三,李四");
        System.out.println(replace);*/
        Demo demo = new Demo(10, "张三");
        Demo demo1 = new Demo(11, "李四");
        Demo demo2 = new Demo(12, "王五");
        ArrayList<Demo> demos = new ArrayList<>();
        demos.add(demo);
        demos.add(demo1);
        demos.add(demo2);
        for (Demo demo3:
             demos) {
            if (demo3.getAge()==11){
                continue;
            }
            System.out.println(demo3.getName());
        }
    }
}
@Data
class Demo{
    private int age;
    private String name;

    public Demo(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
