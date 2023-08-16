package com.example.interface1;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/27
 * \* Description:
 * \* @author 王祥栋
 */
public interface TestInterface {
    String age = "16";
    String name = "张三";
    String desc = "描述";

    default String getNameByOther() {
        return "sdasdasd";
    }

    public abstract void getSomething();

    ;

    static String getAnotherName() {
        return "你好啊";
    }
}
