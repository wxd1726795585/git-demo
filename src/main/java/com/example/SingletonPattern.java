package com.example;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/24
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@Slf4j
public class SingletonPattern {
    private SingletonPattern() {
    }


    private static SingletonPattern singletonPattern;

    /**
     * 饿汉式单例-----线程不安全
     *
     * @return
     */
    public static SingletonPattern getInstance() {
        if (Objects.isNull(singletonPattern)) {
            log.info("第一次创建对象.....");
            singletonPattern = new SingletonPattern();
        }
        return singletonPattern;
    }

    /**
     * 饿汉式单例-----线程安全
     *
     * @return
     */
    public static synchronized SingletonPattern getInstance2() {
        if (Objects.isNull(singletonPattern)) {
            log.info("第一次创建对象.....");
            singletonPattern = new SingletonPattern();
        }
        return singletonPattern;
    }

}
