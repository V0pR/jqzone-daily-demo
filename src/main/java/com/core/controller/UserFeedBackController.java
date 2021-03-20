package com.core.controller;

import com.core.domain.UserFeedBack;
import com.core.service.UserFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v0pr
 */
@RestController("userFeedBackController")
@RequestMapping("user-feed-back")
public class UserFeedBackController {

    @Autowired
    private UserFeedBackService userFeedBackService;

    @PostMapping(value = "/create",produces = "application/json")
    public void create(UserFeedBack userFeedBack){
        userFeedBackService.create(userFeedBack);
    }
}
