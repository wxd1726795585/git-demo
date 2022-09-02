package com.example.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * \* Created with WXD.
 * \* Date:  2022/8/30
 * \* Description:
 * \* @author 王祥栋
 */
public class Test04 implements Runnable{
    Object object=new Object();
    @Override
    public void run() {
        try {
            synchronized (object){
                object.wait();
                System.out.println("大家好啊");
            }
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName()+"开启了一个子线程");
    }

    public static void main(String[] args) {
        String test="aaa";
        System.out.println(StringUtils.isBlank(test)?"空的":"不是空的");
    }
    @Test
    public void test01(){

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private String name;
    private String age;
    private int test;
    private int test001;
}
