package com.core;


import io.ebean.EbeanServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.invoke.MethodHandles;

/**
 * @author wjq
 * @version 1.0
 * @Title: Application
 * @Package com.core
 * @Description:
 * @date 2020/1/8 11:27
 */
@SpringBootApplication
@EnableScheduling
@EnableWebMvc
public class Application implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("===================================== spring boot start success =====================================");
    }

    @Autowired
    private EbeanServer ebeanServer;

}

