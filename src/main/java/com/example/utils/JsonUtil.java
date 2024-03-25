package com.example.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.compress.utils.Lists;
import org.springframework.cglib.beans.BeanMap;

import java.io.IOException;
import java.util.*;

public class JsonUtil {
    private static ObjectMapper INSTANCE = new ObjectMapper();

    private JsonUtil() {
    }

    /**
     * @param obj 准备转换对象
     * @return
     * @description 对象转换成json字符串
     * @author paul
     * @date 2017年7月10日 上午10:54:50
     * @update 2017年7月10日 上午10:54:50
     * @version V1.0
     */
    public static String toJsonStr(Object obj) {
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json 准备转换json
     * @param type 转换类型
     * @return
     * @throws Exception 转换异常
     * @description json字符串转换成对象
     * @author paul
     * @date 2017年7月10日 上午11:08:34
     * @update 2017年7月10日 上午11:08:34
     * @version V1.0
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String json, String type) {
        try {
            return (T) parseJson(json, Class.forName(type));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json  准备转换json
     * @param clazz 转换类型
     * @return
     * @description json字符串转换成对象
     * @author paul
     * @date 2017年7月10日 上午11:12:58
     * @update 2017年7月10日 上午11:12:58
     * @version V1.0
     */
    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return (T) INSTANCE.readValue(json, clazz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json  准备转换json
     * @param clazz 集合元素类型
     * @return
     * @description json字符串转换成对象集合
     * @author paul
     * @date 2017年8月12日 下午1:28:27
     * @update 2017年8月12日 下午1:28:27
     * @version V1.0
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            return (List<T>) INSTANCE.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param collectionClass 集合类
     * @param elementClasses  集合元素类
     * @return
     * @description 获取泛型的ColloectionType
     * @author paul
     * @date 2017年8月12日 下午2:17:38
     * @update 2017年8月12日 下午2:17:38
     * @version V1.0
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return INSTANCE.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * map 进行升序
     *
     * @param map
     * @return
     */
    public static Map<String, String> mapSort(Map<String, String> map) {
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        Map<String, String> resMap = new HashMap<>();
        for (Map.Entry<String, String> resMap1 : list) {
            resMap = (Map<String, String>) resMap1;
        }
        return resMap;
    }


    /**
     * 将map装换为javabean对象
     *
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = maps.size(); i < size; i++) {
                map = maps.get(i);
                try {
                    bean = clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }


    /**
     * 把JSONObject 转换为map(可以转换多层嵌套的json)
     *
     * @param jsonObject
     * @return
     */
    public static Map<String, Object> toMap(JSONObject jsonObject) {
        Map<String, Object> result = new HashMap<>(0);
        Iterator<String> iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object obj = jsonObject.get(key);
            if (obj instanceof JSONObject) {
                List<Map<String, Object>> maps = objToList(obj);
                result.put(key, maps);
                continue;
            }
            if (obj instanceof JSONArray) {
                List<Map<String, Object>> maps = arrayToList(obj);
                result.put(key, maps);
                continue;
            }
            result.put(key, obj);
        }
        return result;
    }

    public static List<Map<String, Object>> arrayToList(Object obj) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (obj instanceof JSONArray) {
            JSONArray jsonArray = JSONArray.fromObject(obj);
            for (int x = 0; x < jsonArray.size(); x++) {
                JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(x));
                Iterator<String> keys = jsonObject.keys();
                Map<String, Object> map = new HashMap<>(0);
                while (keys.hasNext()) {
                    String key = keys.next();
                    Object value = jsonObject.get(key);
                    if (value instanceof JSONArray) {
                        List<Map<String, Object>> maps = arrayToList(value);
                        map.put(key, maps);
                        list.add(map);
                        continue;
                    }
                    if (value instanceof JSONObject) {
                        List<Map<String, Object>> maps = objToList(value);
                        map.put(key, maps);
                        list.add(map);
                        continue;
                    }
                    map.put(key, value);
                }
                list.add(map);
            }
        }
        return list;
    }

    public static List<Map<String, Object>> objToList(Object obj) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (obj instanceof JSONObject) {
            Map<String, Object> map = new HashMap<>(0);
            JSONObject jsonObject = JSONObject.fromObject(obj);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                if (value instanceof JSONObject) {
                    List<Map<String, Object>> maps = objToList(value);
                    map.put(key, maps);
                    list.add(map);
                    continue;
                }
                if (value instanceof JSONArray) {
                    List<Map<String, Object>> maps = arrayToList(value);
                    map.put(key, maps);
                    list.add(map);
                    continue;
                }
                map.put(key, value);
            }
            list.add(map);
        }
        return list;
    }
}
