package com.example.test;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * \* Created with WXD.
 * \* Date:  2023/8/16
 * \* Description:
 * \* @author 王祥栋
 */

public class TestDemo {
    @Test
    public void test01(){
        String originalFilename ="无敌的.zip";
        String substring = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        System.out.println(substring);
    }
}
