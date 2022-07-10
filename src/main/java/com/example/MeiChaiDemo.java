package com.example;

import java.util.HashMap;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/9
 * \* Description:
 * \* @author 王祥栋
 */
public class MeiChaiDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","b");
        map.put("a","c");
        System.out.println(map.get("a"));
    }
}
