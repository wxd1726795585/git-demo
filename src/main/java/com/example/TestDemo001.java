package com.example;

import com.example.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/3/6
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class TestDemo001 {
    public static void main(String[] args) {
       Integer code = null;
        OrderStatus parse = OrderStatus.parse(code);
        System.out.println(parse);
    }
}

@Data
class Student007{
    private String name;
    private String age;
    private Teacher007 teacher007;
}

@Data
class Teacher007{
    private String idCard;
    private String height;
}
@Data
@AllArgsConstructor
class Person007{
    private String idCard;
    private String age;
    private String teacher007;
}
