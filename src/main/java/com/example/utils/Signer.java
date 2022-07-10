package com.example.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/9
 * \* Description:
 * \* @author 王祥栋
 */
public class Signer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Signer.class);

    //组装参数方法按字典升序排列，用&连接
    public static String getSignCheckContent(Map<String, String> params) {
        if (params == null) {
            return null;
        }

        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
        }
        return content.toString();
    }

    //验签方法 content:加密参数   sign:签名  publicKeyPem：平台公钥，非接入方公钥
    public static boolean verify(String content, String sign, String publicKeyPem) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = publicKeyPem.getBytes();
            encodedKey = Base64.decodeBase64(encodedKey);
            PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            Signature signature = Signature.getInstance("SHA1WithRSA");//SHA256WithRSA
            signature.initVerify(publicKey);
            signature.update(content.getBytes(Charset.forName("UTF-8")));
            return signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
            String errorMessage = "验签遭遇异常，content=" + content + " sign=" + sign +
                    " publicKey=" + publicKeyPem + " reason=" + e.getMessage();
            LOGGER.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    //签名方法 content:加密参数  privateKeyPem：私钥
    public static String sign(String content, String privateKeyPem) {
        try {
            byte[] encodedKey = privateKeyPem.getBytes();
            encodedKey = Base64.decodeBase64(encodedKey);
            PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(encodedKey));

            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(privateKey);
            signature.update(content.getBytes(Charset.forName("UTF-8")));
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
            String errorMessage = "签名遭遇异常，content=" + content + " privateKeySize=" + privateKeyPem.length() + " reason=" + e.getMessage();
            LOGGER.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
