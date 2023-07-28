package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * \* Created with WXD.
 * \* Date:  2022/7/7
 * \* Description:
 * \* @author 王祥栋
 */
public class TestDemo {
    @Test
    public void redis() {
        String str="1133714892335882240-wwxxdd";
        String substring = str.substring(20);
        System.out.println(substring);

    }

    @Data
    @AllArgsConstructor
    class Person {
        private String name;
        private String age;
    }


}
