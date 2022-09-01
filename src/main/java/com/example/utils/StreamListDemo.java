package com.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StreamListDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "3", "4");
        String join = String.join(",", stringList);
        System.out.println(join);
    }
}
@Data
@AllArgsConstructor
class Student{
    private Integer id;
    private String name;
    private Integer age;
}
