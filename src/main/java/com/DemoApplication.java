package com;

import com.example.config.AsyncThreadPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    /**
     * 自定义Async单线程线程池
     *
     * @return
     */
    @Bean
    public AsyncTaskExecutor singleExecutor() {
        return new AsyncThreadPoolConfig(1, 1, 10000, 60,
                "async-single-thread-pool").getThreadPool();
    }
}
