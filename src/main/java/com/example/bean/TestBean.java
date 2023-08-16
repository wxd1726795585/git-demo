package com.example.bean;

import com.example.interface1.TestInterface;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/25
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@Component
public class TestBean implements TestInterface {

    public static void main(String[] args) throws ParseException {
        String str ="111111111111111111111111111111";
        System.out.println(str.length());
    }

    private static String getDesc() {
        try {
            int i = 1 / 1;
            return "C";
        } catch (Exception e) {
            return "A";
        }finally {
            return "B";
        }
    }


    @Override
    public void getSomething() {

    }
}
