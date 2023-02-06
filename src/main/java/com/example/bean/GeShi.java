package com.example.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * \* Created with WXD.
 * \* Date:  2023/2/1
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@ToString
public class GeShi {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String beginTime;
}
