package com;

import com.example.bean.TestBean;
import com.example.config.AsyncThreadPoolConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
@MapperScan("com.example.mapper")
@SpringBootApplication
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * 自定义健康测评结果导出线程池
     *
     * @return AsyncTaskExecutor
     */
    @Bean
    public AsyncTaskExecutor healthResultExportExecutor() {
        return new AsyncThreadPoolConfig(1, 1, 9999, 10,
                "async-healthResultExport-thread-pool").getThreadPool();
    }

    @Bean
    public TestBean getTestBean(){
        TestBean testBean = new TestBean();
        return testBean;
    }
}

