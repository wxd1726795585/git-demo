package com.example.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.HygResponse;
import com.example.utils.AESUtils;
import com.example.utils.HttpUtils;
import com.example.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with WXD.
 * \* Date:  2023/8/14
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class OpenApiTest {
    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSqbzf9ymvUsrAVsW3+g6Z0aTd3Ivmibe8rj6mhu3x67eN8WFQBjyPc2k/aq61fQlc0At2WyECbD/jwwgNKscVFiVZx7saiQVTfFFQjnb81Zm3oRWe//Br14Rw1JSMjPJLWgHKjYrynyKP5uoOr59gJ7pHYS5Dt8DtdzljghWnQQIDAQAB";
    /**
     * 私钥
     */
    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJKpvN/3Ka9SysBWxbf6DpnRpN3ci+aJt7yuPqaG7fHrt43xYVAGPI9zaT9qrrV9CVzQC3ZbIQJsP+PDCA0qxxUWJVnHuxqJBVN8UVCOdvzVmbehFZ7/8GvXhHDUlIyM8ktaAcqNivKfIo/m6g6vn2AnukdhLkO3wO13OWOCFadBAgMBAAECgYAfM0jhBH2ztJM5c7xANUwh4P2HzUFd2/Jgi1j8qDu6eYDlC3K+SXVctxquyQ09wsnZGtE1bpGJKGo3E+iElJMhT6yxHYvUiNlVni7NLQGHp2Nb4ZdwUMH1KdeVpOu/Xnns6BiEuRMfpxDWu7bE0zpyqjurUf0gmET3HPXRzjEqgQJBAOTUfIfgmQBXZPIXvpo0P20duludkArOCtvlfaYVDA5HpjbFhZKR4N6A0koxTd927u4PorWAHBX/cptE2CK3fHkCQQCkE7R7XXX0GSfyn05i5Vb4INrYC5QmfFpgVwSUTpSwSwc51LsN2gZKjnbov6W2D5UXeIYWD2zBtp7/HorI5L8JAkA5fxaHQazQBCWOGt8+edBSB30y1eVCgcECvagTmgg8ck5WRs0oJdVdsvqjv720X3rrgCw+9KCZ+mR+lQ7FslrpAkBUV9DKLcQJo7jWTrADxHLNgE4fCuywT/JBXdn7xt1GNntTbhhtyWq8frl/cazkhuQUOZ9rzagReCgJaxDarkPJAkEA0CDCALFkh6FdgtbknYVKs9YKsCSfG58SGYoAZ3Xamss/wsNhvDywge50EqvdqXAfplCLvVY2c2vj71iYQc3MKQ==";
    /**
     * 商户ID
     */
    private static final String COOPERATOR_ID = "C956134827948511232";

    private static final String AES_KEY = "q0oxCftJ4YESnVp9YkRUiQ==";
    /**
     * 企业余额查询接口地址
     */
    private static final String API_COOPERATOR_BALANCE = "https://boapi.hvyogo.com/api/cooperator/balance";

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cooperatorId", COOPERATOR_ID);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));

        // 生成签名
        String s = RSAUtils.sortParam(map);
        String sign = RSAUtils.sign(s.getBytes(), PRIVATE_KEY);
        map.put("sign", sign);

        // 加密数据
        String businessBody = AESUtils.encrypt2Hex(JSONObject.toJSONString(map), AES_KEY);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cooperatorId", COOPERATOR_ID);
        jsonObject.put("businessBody", businessBody);

        try {
            String s1 = HttpUtils.postJson(API_COOPERATOR_BALANCE, jsonObject.toJSONString());
            if (StringUtils.isBlank(s1)) {
                log.error("企业余额查询接口返回数据为空");
            }
            HygResponse hygResponse = JSONObject.parseObject(s1, HygResponse.class);
            Object data = hygResponse.getData();
            String s2 = AESUtils.decryptByHex(data.toString(), AES_KEY);

            JSONObject decryptData = JSONObject.parseObject(s2, JSONObject.class);
            log.info("返回结果为:-{}-", decryptData);

        } catch (Exception e) {
            log.error("企业余额查询接口失败,失败原因:", e);
        }
    }

    @Test
    public void test(){
        BigDecimal bigDecimal = new BigDecimal("0");
        int i = bigDecimal.compareTo(BigDecimal.ZERO);
        System.out.println(i);
    }

    @Test
    public void test01(){
        System.out.println("test.....");
    }
}
