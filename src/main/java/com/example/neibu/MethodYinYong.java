package com.example.neibu;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/27
 * \* Description:
 * \* @author 王祥栋
 */
public class MethodYinYong {
    @Test
    public void demo() {
        Student student = new Student("张三", "16");
        Supplier<String> sk1 = () -> student.getName();
        String s = sk1.get();
        System.out.println(s);
        Function<Student, String> func1 = Student::getName;
        List<String> list=new ArrayList<>();
        list.stream().filter(x->{
            if (x.equals("1")){
                return Boolean.FALSE;
            }else {
                return Boolean.TRUE;
            }
        });

    }
}

@Data
@AllArgsConstructor
class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
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
}
