package com.example.demo;

import java.io.File;

/**
 * \* Created with WXD.
 * \* Date:  2022/1/13
 * \* Description:
 */
public class TestDemo01 {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\wxd.txt");
        boolean newFile = file.createNewFile();

    }
}
