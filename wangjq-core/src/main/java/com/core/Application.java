package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wjq
 * @version 1.0
 * @Title: Application
 * @Package com.core
 * @Description:
 * @date 2020/1/8 11:27
 */
@SpringBootApplication(scanBasePackages = {"com.core"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

