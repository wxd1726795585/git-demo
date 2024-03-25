package com.example.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanCopier工具类
 * 1. 简单复制BeanCopier性能最好
 * 2. 如果需要复杂的复制功能可以使用orika, 且orika支持深拷贝;
 * 3. 一旦使用Converter, BeanCopier只使用Converter定义的规则去拷贝属性, 所以在convert方法中要考虑所有的属性;
 *
 * @author fuchangshun
 * @date 2021-06-01 10:30:41
 */
public class BeanCopyUtils {

    /**
     * CACHE
     */
    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();

    /**
     * 工具类-私有构造
     */
    private BeanCopyUtils() {
    }

    /**
     * COPY
     *
     * @param source source
     * @param target target
     */
    public static <T> T copy(Object source, T target) {
        String key = genKey(source.getClass(), target.getClass());
        BeanCopier beanCopier;
        if (BEAN_COPIER_CACHE.containsKey(key)) {
            beanCopier = BEAN_COPIER_CACHE.get(key);
        } else {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_CACHE.put(key, beanCopier);
        }
        beanCopier.copy(source, target, null);
        return target;
    }

    /**
     * CACHE-KEY
     *
     * @param srcClazz srcClazz
     * @param tgtClazz tgtClazz
     * @return string
     */
    private static String genKey(Class<?> srcClazz, Class<?> tgtClazz) {
        return srcClazz.getName() + tgtClazz.getName();
    }

}