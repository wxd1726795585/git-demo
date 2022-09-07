package com.example.design;

import io.netty.util.internal.ObjectUtil;
import org.springframework.util.ObjectUtils;

/**
 * \* Created with WXD.
 * \* Date: 2022/9/7
 * \* Description:
 * @author WXD
 */
public class SingletonTest02 {
    /**
     * 懒汉式单例模式——啥时候创建啥时候给你对象
     * @param args
     */
    public static void main(String[] args) {
        //懒汉式单例模式
        Order instance = Order.getInstance();
    }
}
class Order{
    /**
     * 1.私有化构造方法
     */
    private Order(){
    }

    /**
     * 2.初始化此对象(为什么静态,对外提供的静态方法,必须访问静态属性)
     */
    private static Order order=null;

    public static Order getInstance(){
        if (ObjectUtils.isEmpty(order)){
            //为空再去创建
            order=new Order();
        }
        return order;
    }
}
