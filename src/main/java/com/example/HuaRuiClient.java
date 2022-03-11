package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.req.HuaRuiYunSmsReq;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
 * \* Created with WXD.
 * \* Date: 2021/11/11
 * \* Description:华瑞短信测试用例
 */
@Data
@Slf4j
public class HuaRuiClient {
    //【慧用工】验证码150262用于登录验证,请不要向任何人泄露。有效期5分钟。
    //【慧用工】验证码666666用于签约验证，请不要向任何人泄露。有效期5分钟。
    //【慧用工】尊敬的客户您好,验证码666666用于电子签约，请不要向任何人泄露。有效期30分钟。
    //【慧用工】尊敬的用户，您在会众包平台发起的个体工商户申请未通过审核，请登录会众包小程序查看详情。
    //【慧用工】验证码166266用于付款验证，请不要向任何人泄露。有效期5分钟。
    //【慧用工】商户望乡商户,于2021-02-11发起的开票申请被驳回。请联系平台业务人员。
    //【慧用工】尊敬的无敌无敌商户，您好！您慧用工的银行卡通道的充值10000000元已到账，到账时间为2021-02-02。感谢您对慧用工的支持，祝您生活愉快。
    //【慧用工】验证码051666用于获取密钥，请不要向任何人泄露。有效期5分钟。
    //【慧用工】灵活用工系统提醒您上帝向您的账户0506结算(服务费)666666元，请注意查收。了解更多灵活用工，请关注微信公众号“慧用工平台"
    //【慧用工】灵活用工系统提醒您，您的账户0304收到服务费1元，请注意查收。了解更多灵活用工，请关注微信公众号“慧用工平台"
    //【慧用工】灵活用工系统提醒您，李丹啊向您尾号为0506的银行账户结算(服务费)1000元，请注意查收。了解更多灵活用工，请关注微信公众号“慧用工平台"
    public static void main(String[] args) {
        HuaRuiYunSmsReq huaRuiYunSmsReq = sendSms("15340812476", "李丹啊向您尾号为0506的银行账户结算(服务费)1000元，请注意查收。了解更多灵活用工，请关注微信公众号“慧用工平台\"");
        System.out.println(huaRuiYunSmsReq);
    }

    private static final String url = "http://39.97.4.102:9090/sms/batch/v1";
    private static final String appcode = "1000";


    /**
     * @param phone   手机号码
     * @param content 短信内容
     * @return
     */
    public static HuaRuiYunSmsReq sendSms(String phone, String content) {
        HttpClient httpClient = null;
        HttpPost httppost = null;
        HuaRuiYunSmsReq huaRuiYunSmsReq = null;
        try {
            httpClient = new DefaultHttpClient();
            httppost = new HttpPost(url);
            Map<String, String> map = new HashMap<String, String>();
            map.put("appkey", "hzMKXO");
            map.put("appcode", appcode);
            String timestamp = System.currentTimeMillis() + "";
            //时间戳精确到毫秒
            map.put("timestamp", timestamp);
            //手机号码
            map.put("phone", phone);
            //发送的短信内容
            map.put("msg", content);
            String sign = md5("hzMKXO" + "w7M645" + timestamp);
            //签名
            map.put("sign", sign);
            String json = JSONObject.toJSONString(map);
            StringEntity formEntity = new StringEntity(json, "utf-8");
            httppost.setEntity(formEntity);
            HttpResponse httpresponse = null;
            httpresponse = httpClient.execute(httppost);
            HttpEntity httpEntity = httpresponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "utf-8");
            log.info("华瑞云短信返回值:-[{}]-", response);
            huaRuiYunSmsReq = JSONObject.parseObject(response, HuaRuiYunSmsReq.class);
            return huaRuiYunSmsReq;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httppost != null) {
                httppost.abort();
            }
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
        return null;
    }


    private static String md5(String param) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Byte = md5.digest(param.getBytes("utf8"));
        String result = byteToHex(md5Byte);
        return result;
    }


    private static String byteToHex(byte[] md5Byte) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        for (byte each : md5Byte) {
            int value = each & 0xff;
            String hex = Integer.toHexString(value);
            if (value < 16) {
                sb.append("0");
            }
            sb.append(hex);
        }
        result = sb.toString();
        return result;
    }


    public static int byte4ToInteger(byte[] b, int offset) {
        return (0xff & b[offset]) << 24 | (0xff & b[offset + 1]) << 16 |
                (0xff & b[offset + 2]) << 8 | (0xff & b[offset + 3]);
    }
}
