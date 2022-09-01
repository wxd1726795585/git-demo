package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * \* Created with WXD.
 * \* Date:  2022/8/29
 * \* Description: 通过Callable 和Future创建
 * \* @author 王祥栋
 */
public class Test03 implements Callable {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(test03);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Integer integer = futureTask.get();
            System.out.println(integer+"————获取到的结果......");
        }catch (Exception e){

        }
    }
}
