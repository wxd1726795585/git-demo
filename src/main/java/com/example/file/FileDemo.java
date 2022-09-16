package com.example.file;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Arrays;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/13
 * \* Description: File类的练习
 * \* @author 王祥栋
 */
@Slf4j
public class FileDemo {
    public static void main(String[] args) throws Exception {


    }
}
class FileDemo02{
    public static void main(String[] args) throws Exception{
        //使用FileReader和FileWriter实现文本文件的复制
        File file = new File("d:" + File.separator + "wxd.txt");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int data;
        while ((data=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,data));
        }
    }
}
