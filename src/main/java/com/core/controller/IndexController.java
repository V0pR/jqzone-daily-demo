package com.core.controller;

import com.core.utils.MJCookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletResponse;

/**
 * @author wangj
 * @version 1.0
 * @Title: LoginController
 * @Package com.core.controller
 * @Description: TODO
 * @date 2020/3/18 0:36
 */
@Controller("indexController")
@RequestMapping("/index")
public class IndexController {
    Logger logger =  LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response) {
        response.addCookie(MJCookieUtils.generateCookie("CID", "", "/", 0));
        response.addCookie(MJCookieUtils.generateCookie("EID", "-1", "/", 0));
        response.addCookie(MJCookieUtils.generateCookie("signature", "", "/", 0));
        return "login";
    }

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index() {
        return "erp/index";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "erp/register";
    }
}
