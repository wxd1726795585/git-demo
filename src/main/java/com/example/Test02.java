/*
package com.example;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

*/
/**
 * \* Created with WXD.
 * \* Date:  2022/2/8
 * \* Description:io流的练习
 *//*

public class Test02 {
    public static void main(String[] args) throws Exception{
        */
/*File file = new File("D:\\code\\wxd.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter("D:\\code1\\wxd.txt");
        char[] chars=new char[6];
        int i;
        while ((i=fileReader.read(chars))!=-1){
            fileWriter.write(chars,0,i);
            fileWriter.flush();
        }
        fileReader.close();
        fileWriter.close();
        file.delete();*//*

        //系统分隔符
        */
/*String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);
        File file = new File("D:\\code\\wxd.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);*//*

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("","15555555555","王祥栋",""));
        students.add(new Student("","","王祥栋",""));
        students.add(new Student("1111","15555555555","王祥栋",""));
        students.add(new Student("","15555555555","王祥栋",""));
        students.add(new Student("11111","15555555555","王祥栋",""));
        students.add(new Student("1111111111","15555555555","王祥栋","11111111111"));
        students.stream().sorted(Comparator.comparing((x,y) -> {
            int x1=0;
            int y1=0;
            if (!StringUtils.isEmpty(x.getFrontUrl())){
                x1++;
            }
            if (!StringUtils.isEmpty(x.getIdCard())){
                x1++;
            }
            if (!StringUtils.isEmpty(x.getName())){
                x1++;
            }
            if (!StringUtils.isEmpty(x.getPhone())){
                x1++;
            }
            if (!StringUtils.isEmpty(y.)){
                y1++;
            }

            if (!StringUtils.isEmpty(y.)){
                y1++;
            }
            if (!StringUtils.isEmpty(x.getName())){
                y1++;
            }
            if (!StringUtils.isEmpty(x.getPhone())){
                y1++;
            }

        }))
    }
}
@Data
class Student{
    private String idCard;
    private String phone;
    private String name;
    private String frontUrl;

    public Student(String idCard, String phone, String name, String frontUrl) {
        this.idCard = idCard;
        this.phone = phone;
        this.name = name;
        this.frontUrl = frontUrl;
    }
}
*/
