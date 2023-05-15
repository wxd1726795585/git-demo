package com.example.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 读取配置文件 不打印key=value
 *
 * @author fuchangshun
 */
@Slf4j
public class PropertiesUtil {


    public static String getProperty(String file, String key, String defaultValue) {
        Locale zhLoc = new Locale("zh", "CN");  //表示中国地区
        ResourceBundle rb = ResourceBundle.getBundle(file, zhLoc);
        try {
            return rb.getString(key);
        } catch (Exception var5) {
            return defaultValue;
        }
    }


    public static String getProperty(String file, String key, String encode, String defaultValue) {
        ResourceBundle rb = ResourceBundle.getBundle(file);
        try {
            return new String(rb.getString(key).getBytes(StandardCharsets.ISO_8859_1), encode);
        } catch (Exception var6) {
            return defaultValue;
        }
    }


    public static Map<String, String> getValuesByPrefix(String file, String prefix) {
        HashMap<String, String> values = new HashMap<>(12);
        ResourceBundle rb = ResourceBundle.getBundle(file);
        try {
            for (String key : rb.keySet()) {
                if (key.startsWith(prefix)) {
                    String value = rb.getString(key);
                    //log.info(key + "=" + value);
                    values.put(key, value);
                }
            }
            return values;
        } catch (Exception var7) {
            return values;
        }
    }


}

