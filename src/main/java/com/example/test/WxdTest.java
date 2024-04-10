package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/3/25
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@AllArgsConstructor
public class WxdTest {
    private String age;
    private String name;
    public static void main(String[] args) {
        WxdTest wxdTest = new WxdTest("16", "王祥栋");
        WxdTest wxdTest1 = new WxdTest("17", "李四");
        WxdTest wxdTest2 = new WxdTest("18", "王五");
        List<WxdTest> wxdTests = Arrays.asList(wxdTest, wxdTest1, wxdTest2);
        for (int i = 0; i < wxdTests.size(); i++) {
            WxdTest wxdTest3 = wxdTests.get(i);
            wxdTest3.setAge("19");
        }
        System.out.println(wxdTests);

    }
}
@Data
class WxdTest01{
    private String age;
    private String name;
    private List<WxdInfo> list;
}
@Data
@AllArgsConstructor
class WxdInfo{
    private String idCard;
    private String height;
}
