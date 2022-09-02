package com.example.base;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/2
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class BusinessException extends RuntimeException{
    private String msg;
    public BusinessException(String msg){
        super(msg);
        this.msg=msg;
    }
}
