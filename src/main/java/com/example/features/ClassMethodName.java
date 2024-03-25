package com.northcastle.H_method_reference;

/**
 * author : northcastle
 * createTime:2022/2/23
 */

import com.example.features.MethodReference;

import java.util.function.BiFunction;

public class ClassMethodName {
    public static void main(String[] args) {
        //0.定义一个字符串作为输入参数,一个对象作为方法的调用者
        String inParam = "Java从入门到精通";
        MethodReference mr = new MethodReference();
        //1.匿名内部类的写法
        String s1 = showMessage(new BiFunction<MethodReference,String, String>() {
            @Override
            public String apply(MethodReference mr,String s) {
                System.out.println("匿名内部类中接收到的参数 ： "+s);
                return "A "+s;
            }
        }, mr,inParam);
        System.out.println("匿名内部类的写法 ： s1 = "+s1);
        System.out.println("=====================");
        System.out.println();

        //2.Lambda表达式的写法
        String s2 = showMessage((mrp,ip) -> {
            System.out.println("Lambda 表达式中接收到的参数 ：" + ip);
            return "B " + ip;
        }, mr,inParam);
        System.out.println("Lambda表达式的写法 ：s2 = "+s2);
        System.out.println("=====================");
        System.out.println();

        //5.方法引用的写法 ： 类名::实例方法名
        /**
         * MethodReference::handleString03 是一个普通的实例方法；
         * handleString03 的参数列表和返回值 与抽象方法 apply() 一致！
         * 为什么一致呢？
         * 因为在此时的方法调用中，
         * 1.apply的第一个参数 MethodReference的对象，作为当前方法handleString03(String)
         * 方法的调用者；
         * 2.而第二个参数 inParam 才真正作为 handleString03(String) 的参数！
         */
        String s5 = showMessage(MethodReference::handleString03,mr, inParam);
        System.out.println("【类名::实例方法名】 方式的方法引用写法 ： s5 = "+s5);
        System.out.println("=====================");
        System.out.println();

    }

    /**
     * 1.一个方法：输入一个值，经过转换处理后，输出另一个值，并返回
     * @param function  接口对象
     * @param mr   参数一 ： 方法调用者对象
     * @param inParam 参数二 ： 被调用方法的参数
     * @return
     */
    public static String showMessage(BiFunction<MethodReference,String, String> function, MethodReference mr,String inParam){
        // 特别注意这里的 apply() 方法 ：
        // 在 【类名::实例方法】的方法调用中
        // 第一个参数实际上是方法的调用者，
        // 第二个参数才是真正的参数
        String outParam = function.apply(mr,inParam);
        return outParam;
    }

}

