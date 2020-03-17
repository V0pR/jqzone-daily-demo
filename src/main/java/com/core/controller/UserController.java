package com.core.controller;

import com.core.domain.User;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangj
 * @version 1.0
 * @Title: UserController
 * @Package com.core.controller
 * @Description: TODO
 * @date 2020/3/17 0:57
 */
@RestController("userController")
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(name = "registered", produces = "applicaation/json")
    public void create(User user) {
        userService.registered(user);

    }


}
