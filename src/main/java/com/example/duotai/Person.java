package com.example.duotai;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/25
 * \* Description: 多态性的展现
 * \* @author 王祥栋
 */
public class Person {
    public void eat(){
        System.out.println("吃饭....");
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        Object[] objects = list.toArray();
    }
    @Test
    public void test001(){
        //Lambda表达式的写法
        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1,o2);
        int compare = c2.compare(1, 2);
        System.out.println(compare);
    }
}

class Man extends Person {
    @Override
    public void eat() {
        System.out.println("男人大口大口的吃饭....");
    }
}

class Woman extends Person {
    @Override
    public void eat() {
        System.out.println("女人细嚼慢咽的吃饭....");
    }
}
