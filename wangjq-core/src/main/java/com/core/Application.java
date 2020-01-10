package com.core;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wjq
 * @version 1.0
 * @Title: Application
 * @Package com.core
 * @Description:
 * @date 2020/1/8 11:27
 */
@SpringBootApplication(scanBasePackages = {"com.core"})
@EnableScheduling
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter {

    private EbeanServer ebeanServer = Ebean.getDefaultServer();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

