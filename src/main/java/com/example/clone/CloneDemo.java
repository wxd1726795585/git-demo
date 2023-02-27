package com.example.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/22
 * \* Description: 关于克隆的demo测试
 * \* @author 王祥栋
 */
public class CloneDemo implements Cloneable{
    public static void main(String[] args) {

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Features{
    /**
     *  身高单位cm
     */
    private String height;
}
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
class Student implements Cloneable{
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 名称
     */
    private String name;
    /**
     * 特征
     */
    private Features features;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student clone = (Student)super.clone();
        String height = clone.getFeatures().getHeight();
        clone.setFeatures(new Features(height));
        return clone;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        //深克隆 前提重写了clone方法
        Features features = new Features("170");
        Student student = new Student(16, "李四", features);
        Student clone = (Student)student.clone();
        System.out.println("源对象:"+student+"-克隆后的对象:"+clone);
        features.setHeight("185");
        System.out.println("源对象:"+student+"-克隆后的对象:"+clone);
    }
}


