package com.example.file;

import java.io.*;
import java.nio.file.Path;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/13
 * \* Description:缓冲流的测试
 * \* @author 王祥栋
 */
public class BufferedTest {
    public static void main(String[] args) {
        String s = "T";
        String s1 = s;
        String str=Long.valueOf(System.currentTimeMillis())+ s1;
        boolean t = str.endsWith("T");
        System.out.println(t);
        System.out.println(str);
        //缓冲输入流
        BufferedInputStream bufferedInputStream=null;
        //缓冲输出流
        BufferedOutputStream bufferedOutputStream=null;
        try{
            File file = new File("D:" + File.separator + "wxd.txt");
            Path path = file.toPath();
            File fileCopy = new File("D:" + File.separator + "copy.txt");
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[1024];
            int data;
            while ((data=bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,data);
                bufferedOutputStream.flush();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
