package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.AESUtils;
import com.example.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * \* Created with WXD.
 * \* Date:  2024/5/17
 * \* Description: openApi解密
 * \* @author 王祥栋
 */
@Slf4j
public class OpenApiDecrypt {
    /**
     * 商户ID
     */
    private static final String COOPERATOR_ID = "C1238137773085437952";
    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBALeDKoKV1SyaP37/4zLTDxEcUSe8ov5tG5mv0j4X8iZFkLFIFt1/EoYJUMyPPpVkcciAtmWD+HV1mMVs5wiVbEf/MST5YgwxpM7/qY2F0Ez1dDu5TLXjAol7qx0gnEM5H3qcNTd6+/fwXmV+cqnMPzpRvA9lg5P+VadEWRF56tdhAgMBAAECgYEAmLsB1kz9bnGyBvDRFquyDnuSz4+f2EDWh8JdKHCliFS9Z86nuRDZSdTW+mj9nThLuqPlKff8AUYuL6HDZtF1m8zpnn99kTwV+XNxJj3vc0EEQO13uyXRT0u2c+BTmkw/q/VSrbC8WO5oOqDbmpWwSpKyAQNIqxyjhLT2ePINAwECQQDktD6zm0OwApy/4HL0/UjwJytmY0V7Oaat9CJeDbV8oFzZYw8rGOmgTklocQBfkBH+/KGW6TWuwrsOm5TCZm69AkEAzWolr3RAA0oVXkyzUF2i2FvZMiExyZNRqIP94dYlDdpkxxuWKRczqOUwGAE7jdNG8reGyfoMIbJ01/f/CthXdQJBALLZrgshCa70bAa1jNC/3rFHwG3ihiyWah2xRMsOp3Xdpp6uE+edJN6jOk79x8/zx88DW467s6qGSGhlDNF173UCQQCT8L7zfmYb+F8ra1I5rzZ5XK0wzXduFgvZsjZHUFOfhorOW6/qKCusmGPq5fheTKvsYwFQtiXGnyBH6vRkeyuBAkEA2auCnVn9JmtyBim1++k8yftI3siKdbPYZx3O8ogLtdM3zsupkfQ6WMflJB1e6ojtmEZgJygT45hHnKUw5tLwKA==";
    private static final String PUBLIC_KEY1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxkHS4PUq1ffcfNs0S5Qfje5F4bKi3y02WVciq14cld4THm6ZGfCAtju/gT/t3V/p44Owy0EDbiYkLYxgiOYJeViNPRHWjoftcwXzRZz38vK/g4LXxU1BQA2ihmwpgBU9ayFLymVbGUY7laSo/0BMKAxQ2PM161ormNaCmJjmyJQIDAQAB";
    /**
     * 密钥
     */
    private static final String SECRET_KEY = "uqRv/+H6nC66dbKAfXddww==";

    public static void main(String[] args) {
        System.out.println(PUBLIC_KEY.length());
        String businessBody = "C59831B724A80490EE49D47175DE23C94ADF82E4D337C7672CC71240D4E656F4A068CFC628A0CE96EF4524C0D70927073835F90C99F459F4F7A4AFD449C22EA24A2E86FDD9C9D26D1D5264DD00496D4480CF789FBDFB5C985B0F69A7D5C9183C3DFB68251A996BBBB26304CE8A9A8A31D7CD293AC27F59E2EA3C3C25B6BFA143DA7324D6E4711A841CE2B49582A47A86FBF4261D26977178A52DD7A2ABE294AE5966A247D72429173045D42ED73D49D74A8AE090AD99A186A0F6C281A2BE6711319400F1D0BFF664DB384E6195AEC076D0801D2D213F1A7FE80D9172560263A98CB5711BA674D69FF72F5228A760C43769DA847E6F471EAFF53D72F0EE1D958E68D2F7B7DAD0135662472BE429D33CC282751AE38A09F935C226D9250A7E9952F16DFE0B5B9B36C63536C00EB59D2554B0B8A075A4BD61A9FF051D89A719258069624BA6EE3D4B5CCC62411E5F38C14E";
        try {
            businessBody = AESUtils.decryptByHex(businessBody, SECRET_KEY);
            Map<String, Object> baseVo1 = JSONObject.parseObject(businessBody, Map.class);
            System.out.println(baseVo1);
            String sign = String.valueOf(baseVo1.get("sign"));
            baseVo1.remove("sign");
            String sortStr = RSAUtils.sortParam(baseVo1);
                if (!RSAUtils.verify(sortStr.getBytes(), PUBLIC_KEY, sign)) {
                    log.error("验签失败,参数可能被篡改 cooperatorId:{}", COOPERATOR_ID);

                }
        } catch (Exception e) {
            log.error("解密失败",e);
        }
    }
}
