package com.core.controller;

import com.core.domain.User;
import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjq
 * @version 1.0
 * @Title: UserController
 * @Package com.core.controller
 * @Description:
 * @date 2020/1/16 11:18
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping(value = "register",produces = "application/json")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    /**
     * update password
     */
    @PutMapping(value = "update-password/{userId}",produces = "application/json")
    public void updatePassword(@RequestParam("password") String password,
                               @PathVariable Long userId){
        userService.updatePassword(userId,password);

    }

    /**
     * update
     * @param user
     */
    @PutMapping(value = "update/{userId}",produces = "application/json")
    public void update(@RequestBody User user){
        userService.update(user);

    }


    public static void main(String[] args) {
        SCryptPasswordEncoder sCryptPasswordEncoder =  new SCryptPasswordEncoder();
        System.err.println(sCryptPasswordEncoder.encode("123"));
    }





}
