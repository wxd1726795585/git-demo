package com.example.bean;

import com.alibaba.fastjson.JSONObject;
import com.example.interface1.TestInterface;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/25
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@Component
public class TestBean implements TestInterface {

    public static void main(String[] args) throws ParseException {

    }

    private static String getDesc(){
        String str="A";
        switch (str){
            case "A":
                return "A";
            case "B":
                return "B";
        }
        return "dsdsds";
    }


}
