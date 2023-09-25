package com.example.thread;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/25
 * \* Description:
 * \* @author 王祥栋
 */
public class ThreadTest implements Runnable{
    @Override
    public void run() {
        System.out.println("另一个线程");
    }


}
