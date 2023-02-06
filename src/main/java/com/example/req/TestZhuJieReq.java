package com.example.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * \* Created with WXD.
 * \* Date:  2023/1/6
 * \* Description: 测试注解的功能
 * \* @author 王祥栋
 */
@Data
public class TestZhuJieReq {
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String gender;
    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    private Integer age;
}
