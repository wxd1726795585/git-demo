package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.Signer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/9
 * \* Description:
 * \* @author 王祥栋
 */
public class MeiChai {
    /**
     * 请求服务地址
     */
    private static String serviceurl ="http://10.hunhun.in/gateway";
    public static void main(String[] args) {
        //String serviceurl = "http://10.hunhun.in/gateway";

        //1.封装业务参数
        String username = "陈龙";
        String useridcard ="4155515";
        String usermobile= "17626678";
        String userbankno="62166602";
        String salary= "100";
        String salarymemo= "测试工资";
        String outtradeno= "test202102230001";

        JSONObject content = new JSONObject();
        content.put("outtradeno", outtradeno);
        content.put("salary", salary);
        content.put("username", username);
        content.put("useridcard", useridcard);
        content.put("usermobile", usermobile);
        content.put("salarymemo", salarymemo);
        content.put("userbankno", userbankno);
        String biz_content = content.toJSONString();
        System.out.println("业务参数s1" + biz_content);

        //2.封装请求参数s2（即params，未加入签名）
        Map<String, String> params = new HashMap<String, String>();
        params.put("merchant_id", "1yao");
        params.put("merchant_name", "1药王");
        params.put("method", "add.to.salarybill");
        params.put("version", "1.0");
        params.put("biz_content",biz_content);
        //params.put("timestamp", DateUtils.getDateFormatByDate14(new Date()));
        params.put("sign_type", "RSA");
        //content加密参数
        String content1 = Signer.getSignCheckContent(params);
        System.out.println("param=" + content1);
        //私钥
        String privateSecret = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJddrY5w0=";
        //3.对排好序的s2进行加密得到签名sign
        String sign = Signer.sign(content1,privateSecret);
        System.out.println(sign);
        //4.最终请求参数params(s2加入签名）
        params.put("sign", sign);
        String paramsStr = JSONObject.toJSONString(params);
        System.out.println(paramsStr);

    }
}
