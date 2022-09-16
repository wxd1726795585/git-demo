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
        File file = new File("d:" + File.separator + "wxd.txt");
        /*//绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println("绝对路径........."+absolutePath);
        //获取路径
        String path = file.getPath();
        System.out.println("普通路径......."+path);
        //获取名称
        String name = file.getName();
        System.out.println("名称....."+name);*/
        /*FileReader fileReader = new FileReader(file);
        char[] chars=new char[5];
        int data;
        while ((data=fileReader.read(chars)) !=-1){
            log.info("data-{}-",data);
            System.out.println(new String(chars,0,data));
        }
        int read = fileReader.read();*/
        boolean contains = Arrays.asList("1").contains("1");
        System.out.println(contains);
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
