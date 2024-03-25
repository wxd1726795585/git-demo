package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.HygResponse;
import com.example.req.MimsUploadMrPictureReq;
import com.example.req.OnlineTrainReq;
import com.example.utils.BeanCopyUtils;
import com.example.utils.GsonUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.AntPathMatcher;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/11/10
 * \* Description:
 * \* @author 王祥栋
 */
public class Test008 {
    public static void main(String[] args) throws Exception {
        Test12 test12 = new Test12();
        Integer i = 0;
        int y = 0;
        test12.setAge(y == 1 ? 0 : ++i);
        System.out.println(test12.getAge());


    }

    /**
     * 路径匹配器
     */
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    /**
     * URI匹配
     *
     * @return 匹配结果
     */
    public static boolean match(List<String> patterns, String path) {
        return patterns.stream().anyMatch(pattern -> ANT_PATH_MATCHER.match(pattern, path));
    }

    // 设置-trainCoursewareName
    public static void setValue(Object obj) throws Exception {
        Class<?> aClass = obj.getClass();
        Field trainCoursewareName = aClass.getDeclaredField("trainCoursewareName");
        trainCoursewareName.setAccessible(Boolean.TRUE);
        String value = (String) trainCoursewareName.get(obj);
        System.out.println(value);
        if (StringUtils.isBlank(value)) {
            trainCoursewareName.set(obj, "无敌");
        }
    }


    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(object, Object.class);
    }

    public static String getJson(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
        String s = toJson(target);
        return s;
    }

    public static String removeUnderscoreAndCamelCase(String input) {
        // Split the input string by underscore
        String[] parts = input.split("_");

        // Capitalize the first letter of each part and concatenate them
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            result.append(capitalizeFirstLetter(part));
        }

        return result.toString();
    }

    private static String capitalizeFirstLetter(String str) {
        // Check for empty string
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Capitalize the first letter and append the rest of the string
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Seven {
    private String name;
    private String source;
    private List<Info> test;
}

@Data
class SevenCopy {
    private String name;
    private List<Info> test;
    private String source;
}

@Data
@AllArgsConstructor
class Info {
    private String color;
    private String length;
}

@Data
class Test12 {
    private Integer age;
}
