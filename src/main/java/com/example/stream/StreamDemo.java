package com.example.stream;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/27
 * \* Description: stream流测试
 * \* @author 王祥栋
 */
public class StreamDemo {

    @Test
    public void demo(){
        //List<Student> list =new ArrayList<>();
        //list.add(new Student("张三",15));
        //list.add(new Student("张三",15));
        //list.add(new Student("李斯特",17));
        //list.add(new Student("李斯特",17));
        //list.add(new Student("李斯特1",18));
        //list.add(new Student("李斯特2",19));
        //Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getScore));
        //System.out.println(collect);
        //Student student = new Student("张三", 15);
        //String s = JSON.toJSONString(student);
        //System.out.println(s);
        Date date = new Date(1616601600000L);

    }
}
@Data
@ToString
class Student {
    private String name;
    private int score;

    public Student(){

    }

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int compareByScore(Student student){
        return this.getScore() - student.getScore();
    }

    @Override
    public String toString(){
        return this.name + "  " + this.score + "  ";
    }
}
