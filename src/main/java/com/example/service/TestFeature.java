package com.example.service;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/20
 * \* Description:测试1.8新特性
 * \* @author 王祥栋
 */
@FunctionalInterface
public interface TestFeature {
    void add();
    default void getDefault(){
        System.out.println("default修饰的方法");
    }
    static void getStatil(){
        System.out.println("静态方法");
    }
}
