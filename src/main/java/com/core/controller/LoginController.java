package com.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangj
 * @version 1.0
 * @Title: LoginController
 * @Package com.core.controller
 * @Description: TODO
 * @date 2020/3/18 0:36
 */
@RestController("loginController")
@RequestMapping("login")
public class LoginController {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
