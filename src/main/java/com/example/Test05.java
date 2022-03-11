package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/2/18
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class Test05 {
    public static void main(String[] args) {
        Student001 student001 = new Student001("张三", 10);
        Student001 liSi = new Student001("李四", 10);
        ArrayList<Student001> student001s = new ArrayList<>();
        student001s.add(student001);
        student001s.add(liSi);
        log.info("参数-[{}]-",student001s);

    }
    public static void demo(List list){

    }
}
@Data
@AllArgsConstructor
class Student001{
    private String name;
    private Integer age;
}
@Data
@AllArgsConstructor
class Student002{
    private String name;
    private Integer age;
}
