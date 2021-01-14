package com.core.controller;

import com.core.domain.Session;
import com.core.service.UserService;
import com.core.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

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

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final long EXPIRED_MILLIS = 7 * 24 * 60 * 60 * 1000L;

    @Autowired
    private UserService employeeService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response,
                        @RequestParam("account") String encryptedData) {
        //todo 解密
        String account = encryptedData;
        Optional<Session> optional = Session.finder.findOneOrEmpty(encryptedData);
        if (!optional.isPresent()) {
            Session session = new Session();
            session.setExpiredDate(new Date(System.currentTimeMillis() + EXPIRED_MILLIS));
            session.setAccountId(account);
            sessionService.create(session);
        }
        employeeService.login(response);
        return "login";
    }

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(HttpServletResponse response) {

        return "register";
    }
}
