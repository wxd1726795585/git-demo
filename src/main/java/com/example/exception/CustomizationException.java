package com.example.exception;

import lombok.NoArgsConstructor;

/**
 * \* Created with WXD.
 * \* Date:  2023/1/13
 * \* Description:
 * \* @author 王祥栋
 */
@NoArgsConstructor
public class CustomizationException extends RuntimeException {

    private String msg;
    private String code;

    public CustomizationException(String msq) {
        super(msq);
        this.msg = msq;
        this.code = "10010";
    }
}
