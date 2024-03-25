package com.example.req;

import lombok.Data;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/11/10
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class StudentInfo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 家庭成员名字
     */
    private List<String> familyNameList;
}
