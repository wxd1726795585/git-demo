package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/24
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@ToString
@AllArgsConstructor
public class Student0011 {
    private String name;
    private String age;
    private String gender;

    public static void main(String[] args) {
        String string = getString();
        System.out.println(string);
    }

    public static String getString() {
        try {
            int i = 1 / 0;
            return "111";
        } catch (Exception e) {
            return "2222";
        } finally {
            return "3333";
        }
    }
}
