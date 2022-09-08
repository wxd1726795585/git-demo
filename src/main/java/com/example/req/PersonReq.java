package com.example.req;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/8
 * \* Description:任务请求参数
 * \* @author 王祥栋
 */
@Data
public class PersonReq {
    private String name;
    private String age;
    private String idCard;

    @Override
    public String toString() {
        return "PersonReq{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
