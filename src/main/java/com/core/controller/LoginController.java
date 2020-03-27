package com.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author wangj
 * @version 1.0
 * @Title: LoginController
 * @Package com.core.controller
 * @Description: TODO
 * @date 2020/3/18 0:36
 */
@Controller("loginController")
@RequestMapping
public class LoginController {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
