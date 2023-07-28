package com.example.entity;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/11/17
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class CopyEntity {
    private String id;
    private String name;
    private String gender;
    private String idCard;
    private Integer age;
    private String samplingCycle;
    private Integer deleteFlag;
    private Boolean flag;
}
