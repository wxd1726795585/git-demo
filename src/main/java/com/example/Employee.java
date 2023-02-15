package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/6
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Employee {
    /**
     * 姓名
     */
    @Length
    private String name;
    /**
     * 主键id
     */
    private String id;
    /**
     * 工资
     */
    private double salary;

    /**
     * 工作方法
     */
    public abstract void work();
}
