package com.example.demo;

import lombok.Data;

import java.text.SimpleDateFormat;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/28
 * \* Description:内部类的使用
 * \* @author 王祥栋
 */
@Data
public class NeiBuClass {
    public static void main(String[] args) {
        NeiBuDemo.Student01 student01 = new NeiBuDemo.Student01();
        student01.setAge("15");
        student01.setName("测试");
        student01.setIdCard("测试身份证");

        NeiBuDemo.Animal animal = new NeiBuDemo.Animal();
        animal.setName("测试");
        animal.setType("植物");

        NeiBuDemo neiBuDemo = new NeiBuDemo();
        NeiBuDemo.A a = neiBuDemo.new A();
        neiBuDemo.setStudent01(student01);
        for (int i = 0; i <100 ; i++) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
    }
}

@Data
class NeiBuDemo{
    private Student01 student01;


    @Data
    static class Student01{
        private String name;
        private String age;
        private String idCard;
        public static String D="D";
    }
    @Data
    static class Animal{
        private String name;
        private String type;

    }
    @Data
    class A{
        private String name;
        private String type;
    }
}
