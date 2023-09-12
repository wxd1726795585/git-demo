package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/4
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class TestDemo  {
    private String idCard;
    private TestDemo01 testDemo01;


    public static void main(String[] args) {
       String str ="aa\nbb\ncc";
        System.out.println(str);
    }


}

@Data
class TestDemo01 {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestDemo01{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
