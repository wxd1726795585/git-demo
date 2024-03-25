package com.example.thread;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/25
 * \* Description:
 * \* @author 王祥栋
 */
public class ThreadTest {

    public static void main(String[] args) {
        int count = 0;
        TWO two = new TWO();
        two.setCount(++count);
        System.out.println(two);


    }

}
@Data
class TWO{
    private Integer count;
}
