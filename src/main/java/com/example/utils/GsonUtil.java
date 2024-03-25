package com.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

/**
 * @author fuchangshun
 * @date 2019-06-18 14:49
 */

public class GsonUtil {

    private static Gson gson;

    static {
        gson = new Gson();
    }

    public synchronized static <T> String toJson(T object) {
        return gson.toJson(object);
    }

    public synchronized static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public synchronized static <T> String toJsonWithAnnotation(T object) {
        if (null == object) {
            return null;
        }
        Gson gson02 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization().serializeNulls().disableHtmlEscaping().create();
        return gson02.toJson(object);
    }

    public synchronized static <T> T fromJsonWithAnnotation(String json, Class<T> type) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        //反序列化时根据json串中的字段反向执行, 此处的builder是否对null序列化无意义.
        Gson gson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().enableComplexMapKeySerialization().create();
        return gson.fromJson(json, type);
    }


}
