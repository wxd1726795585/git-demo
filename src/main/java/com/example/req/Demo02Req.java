package com.example.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * \* Created with WXD.
 * \* Date:  2023/12/28
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class Demo02Req {
    /**
     * 姓名
     */
    @Length(min = 10,max = 50,message = "姓名介于10-50之间")
    private String name;
    /**
     * 年龄
     */
    private String age;
}
