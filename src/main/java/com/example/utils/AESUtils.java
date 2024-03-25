package com.example.utils;
import com.example.base.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class AESUtils {

    private static final String ALGORITHM = "AES";

    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) {
        List<String> stringList = decryptUtil("xHuAnkSFpYl+qda+2zRW3Q==", "x5MnqjiSQsRlHizE5suh6A==", "4PFsimcPLmbhHp1D9SazhQ==");
        System.out.println(stringList);
    }

    public static List<String> decryptUtil(String... param) {
        List<String> decryptParam = new ArrayList<>();
        try {
            for (String str : param) {
                decryptParam.add(decryptOfMysql(str, "*&($UHNOPW#890ny"));
            }
        } catch (Exception e) {
            log.error("数据库解密失败", e);
            throw new BusinessException("解密敏感信息异常");
        }
        return decryptParam;

    }
    /**
     * java使用AES加密解密 AES-128-ECB加密
     * 与mysql数据库aes加密算法通用
     * 数据库aes加密解密
     * -- 加密
     * SELECT to_base64(AES_ENCRYPT('www.gowhere.so','jkl;POIU1234++=='));
     * -- 解密
     * SELECT AES_DECRYPT(from_base64('Oa1NPBSarXrPH8wqSRhh3g=='),'jkl;POIU1234++==');
     *
     * @author 836508
     */
    public static String decryptOfMysql(String sSrc, String sKey) throws Exception {
        if (StringUtils.isEmpty(sSrc)) {
            return "";
        }
        try {
            // 判断Key是否正确
            if (StringUtils.isEmpty(sKey)) {
                log.error("密钥为空");
                return "";
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                log.error("Key长度不是16位");
                return "";
            }
            byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //先用base64解密
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, StandardCharsets.UTF_8);
                return originalString;
            } catch (Exception e) {
                log.error("解密失败:e:", e);
                return "";
            }
        } catch (Exception ex) {
            log.error("解密失败:e:", ex);
            return "";
        }
    }

    /**
     * 解密
     *
     * @param content 内容
     * @param key     密钥
     * @return 解密数据
     * @throws Exception Exception
     */
    public static String decryptByHex(String content, String key) throws Exception {
        return decrypt(hex2Byte(content), key);
    }

    /**
     * 解密过程
     *
     * @param encryptBytes 加密字节数组
     * @param key          密钥
     * @return 解密数据
     * @throws Exception Exception
     */
    private static String decrypt(byte[] encryptBytes, String key) throws Exception {
        Key k = toKey(Base64Utils.decodeFromString(key));
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, k);
        return new String(cipher.doFinal(encryptBytes));
    }

    /**
     * 加密(结果为16进制)
     *
     * @param content 内容
     * @param key     密钥
     * @return 加密数据
     * @throws Exception Exception
     */
    public static String encrypt2Hex(String content, String key) throws Exception {
        return byte2Hex(encrypt(content, key));
    }

    /**
     * 加密过程
     *
     * @param content 内容
     * @param key     密钥
     * @return 加密字节数组
     * @throws Exception Exception
     */

    public static byte[] encrypt(String content, String key) throws Exception {
        Key k = toKey(Base64Utils.decodeFromString(key));
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(content.getBytes());

    }

    /**
     * 2进制转16进制
     *
     * @param buff 源数据
     * @return 结果
     */
    public static String byte2Hex(byte[] buff) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte b : buff) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            stringBuffer.append(hex.toUpperCase());
        }
        return stringBuffer.toString();
    }

    /**
     * 16进制转2进制
     *
     * @param hex 源数据
     * @return 结果
     */
    public static byte[] hex2Byte(String hex) {
        if (hex != null && hex.length() >= 1 && hex.length() % 2 == 0) {
            byte[] result = new byte[hex.length() / 2];
            for (int i = 0; i < result.length; ++i) {
                int high = Integer.parseInt(hex.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hex.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high << 4 | low);
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * 解析KEY
     *
     * @param key 源数据
     * @return KEY
     */
    public static Key toKey(byte[] key) {
        return new SecretKeySpec(key, ALGORITHM);
    }

    /**
     * 密钥生成(Demo)
     */
    public static String createAESKey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        //要生成多少位, 只需要修改这里即可128, 192或256
        kg.init(128);
        SecretKey sk = kg.generateKey();
        byte[] b = sk.getEncoded();
        return Base64Utils.encodeToString(b);
    }


}