package com.example.demo;

import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/7
 * \* Description:
 * \* @author 王祥栋
 */
public class OrderDemo {
    public static void main(String[] args) {
        /*
         * .编写Order类，有int型的orderId，String型的orderName，
         * 相应的getter()和setter()方法，两个参数的构造器，重写父类的equals()方法：public boolean equals(Object obj)，
         * 并判断测试类中创建的两个对象是否相等。
         *
         *
         */
        Order order1 = new Order(10, "张三");
        Order order = new Order(10, "张三");
        boolean equals = order.equals(order1);
        //System.out.println(equals);
        String str="aa";
        Object o=new ArrayList<>();


        Integer integer = Integer.valueOf("1");
        System.out.println(integer);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Order{
    /**
     * 订单ID
     */
    private int orderId;
    /**
     * 订单名称
     */
    private String orderName;

    @Override
    public boolean equals(Object object) {
        if (object instanceof Order) {
            Order o = (Order) object;
            if (!(o.getOrderId() == this.getOrderId())) {
                return false;
            }
            if (o.getOrderName().equals(this.getOrderName())) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}