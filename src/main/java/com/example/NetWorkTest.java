package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/6
 * \* Description:zha
 * \* @author 王祥栋
 */
/*
 * 接口的应用:代理模式
 *
 *
 */
public class NetWorkTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(16);
        int i =1;
        list.forEach(x->{
            System.out.println("1111111");
        });
        System.out.println(list.size());
    }
}


