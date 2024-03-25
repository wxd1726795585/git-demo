package com.example.test;

import com.example.enums.KfcWorkerRelationEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/12/25
 * \* Description:
 * \* @author 王祥栋
 */
public class December25th {
    public static void main(String[] args) {
        Integer i =null;
        KfcWorkerRelationEnum parse = KfcWorkerRelationEnum.parse(i);

    }
}

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
