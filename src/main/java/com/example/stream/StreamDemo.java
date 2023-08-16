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
        String str = "ASDF";
        byte[] bytes = str.getBytes();
        for (byte b:
             bytes) {
            System.out.println(b);
        }

    }
    /**
     * 过滤空格
     *
     * @param list 原始数据
     * @return
     */
    public List<String> filterBlankSpace(List<String> list) {
        List<String> cooperatorIdList = new ArrayList<>();
        list.forEach(x -> {
            cooperatorIdList.add(x.trim());
        });
        return cooperatorIdList;
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
