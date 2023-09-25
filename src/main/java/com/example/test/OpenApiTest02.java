package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.HygResponse;
import com.example.utils.AESUtils;
import com.example.utils.HttpUtils;
import com.example.utils.HttpUtils1;
import com.example.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * \* Created with WXD.
 * \* Date:  2023/8/14
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
public class OpenApiTest02 {
    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSqbzf9ymvUsrAVsW3+g6Z0aTd3Ivmibe8rj6mhu3x67eN8WFQBjyPc2k/aq61fQlc0At2WyECbD/jwwgNKscVFiVZx7saiQVTfFFQjnb81Zm3oRWe//Br14Rw1JSMjPJLWgHKjYrynyKP5uoOr59gJ7pHYS5Dt8DtdzljghWnQQIDAQAB";
    /**
     * 私钥
     */
    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKrIfh1TXl4YQJAracsmi2zqxWXzKDTuv5lByMGtErWKFg/O32dwQ1LdBUWDcF3IeDkhgDI23W0Px67IpMgKsTQzKtZnC0WzrSL++qO/HqFWYeLpdHn/q3eHZm+3IhEomGFfn1KbEa8NrwMbCbHO60QnTeOM+qDDe1ISEU2XdO6PAgMBAAECgYEAgKyi6LGBrl+TdYxgH2IhNqUEqbW1G3yu+2enPNWL/R/XU33IsQTSlMJWUHOh2+dJPbJSBoNz/dIf3z7peJclvzV/nYwznP9/k9MM3Z/oqkQDu0uhE+o/NlDKAavBuwHAQ74vi6iO03RvWscS5I6w0zk4usI27bHDCbJIEz4JGaECQQDXKeL2ruQXr+HzURoAxttFcqDYlh3iSsxrCy/gLveYudqn9n5dRr/vxsBC0OBB6sRMS5ZYW1xGAcb8XF2bPaDHAkEAyzJNSYM6SMu+5AdFLgPwg2XctlsR7ZoRdotT95LUhycXT4cEP8/pPc73AOwEcabZfsRGPjm20KapXaM9c40L+QJBAKxtfN2DunbhFIoRbG1C72XwPsZTRw+aMcd2558ZBIL4Lip8dzf5Asf81wa0rYMlyLn7uTiFvqS7t+N1ge5urPECQDNadCP3EVzieU0B9V7qyfc7YCuKGp7VCELQdZklN6csnvyPX+iMsCLZ0p0eCQV8KI2cJzCEv4o+BKHQprA0XmkCQDPOLg6qeqTx6CzbKJTNDHuQhT02/bT63QSpD9nE553738KLbMBirCeLBv04k004oOcBoArz756MB2GbGdKRRuU=";
    /**
     * 商户ID
     */
    private static final String COOPERATOR_ID = "C826846103272955904";

    private static final String AES_KEY = "Aixu/8t7FZMbDvyBc3MBHg==";
    /**
     * 企业余额查询接口地址
     */
    private static final String API_COOPERATOR_BALANCE = "https://boapi.hvyogo.com/api/cooperator/balance";


    private static final String API_GET_STREAM = "https://boapi.hvyogo.com/api/v2/hire/worker/getFileStreamByKey";


    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cooperatorId", COOPERATOR_ID);
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("key", "hvyogo-beta/protocol/2020/11/20201119185826-孙中雪-779058020486221824-50.pdf");

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
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toJSONString());
            Request request = new Request.Builder().url(API_GET_STREAM).post(body).build();
            Response response = HttpUtils1.execute(request);
            writeFile("D:\\wxdwxd.pdf", response);

        } catch (Exception e) {
            log.error("企业余额查询接口失败,失败原因:", e);
        }
    }

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal("0");
        int i = bigDecimal.compareTo(BigDecimal.ZERO);
        System.out.println(i);
    }

    @Test
    public void test01() {
        System.out.println("test.....");
    }

    private static void writeFile(String path, Response response) {
        FileOutputStream fos = null;
        InputStream is = response.body().byteStream();
        File file = new File(path);
        try {
            fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载成功");
    }
}
