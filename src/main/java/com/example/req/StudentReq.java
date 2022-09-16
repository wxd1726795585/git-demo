package com.example.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * \* Created with WXD.
 * \* Date:  2022/9/16
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class StudentReq {
    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空")
    private String name;

    /**
     * 年龄
     */
    private String age;
    /**
     * 身份证号码
     */
    private String idCard;
}
