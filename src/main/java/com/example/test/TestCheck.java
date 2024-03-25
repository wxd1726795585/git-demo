package com.example.test;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/1/16
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class TestCheck {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("111");
        list.add("111");
        list.add("111");
        List<String> list1 =new ArrayList<>();
        list.retainAll(list1);
        System.out.println(list);
    }
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄集合
     */
    @Size(min = 2, max = 3, message = "个数介于2-3个之间")
    private List<String> ageList;
}
