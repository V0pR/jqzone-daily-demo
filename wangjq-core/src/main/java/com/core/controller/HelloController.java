package com.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjq
 * @version 1.0
 * @Title: HelloController
 * @Package com.core.controller
 * @Description: hello
 * @date 2020/1/8 10:35
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/up")
    public String up() {
        return "好好学习，天天向上！";
    }
}
