package com.example.bean;

import com.example.interface1.TestInterface;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

    public static void main(String[] args) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("111","222");
        params.put("000","222222");
        params.put("1222","222333");
        params.put("4333","666666");
        System.out.println(params);
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
