package com.example.test;

import com.example.req.FillAdmissionQualificationReq;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * \* Created with WXD.
 * \* Date:  2024/4/24
 * \* Description:
 * \* @author 王祥栋
 */
public class TestMethod {
    public static void main(String[] args) {

    }

    /**
     * 校验并打印每个字段的名称和值
     *
     * @param req 填写准入资质请求参数对象
     */
    public static void validateInputContent(FillAdmissionQualificationReq req) {
        try {
            // 获取请求对象的Class实例
            Class<? extends FillAdmissionQualificationReq> clazz = req.getClass();

            // 获取所有字段，包括私有字段
            Field[] fields = clazz.getDeclaredFields();

            // 遍历所有字段
            for (Field field : fields) {
                String name = field.getName();

                // 确保可以访问私有和其他作用域的字段
                field.setAccessible(true);

                // 获取字段的值
                Object value = field.get(req);

                // 打印字段名和字段值
                System.out.println("Field name: " + field.getName() + ", Field value: " + value);
            }
        } catch (IllegalAccessException e) {
            // 处理异常，如无法访问字段
            e.printStackTrace();
        }
    }
}
@Data
@AllArgsConstructor
class Animal{
    private String name;
    private String age;
}
@Data
class Dog{
    private String name;
    private String idCard;
}
