package com.core.controller;

import com.core.domain.UserFeedBack;
import com.core.service.UserFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author v0pr
 */
@RestController("userFeedBackController")
@RequestMapping("user-feed-back")
public class UserFeedBackController {

    @Autowired
    private UserFeedBackService userFeedBackService;

    @PostMapping(value = "/create", produces = "application/json")
    public void create(UserFeedBack userFeedBack) {
        userFeedBackService.create(userFeedBack);
    }

    @GetMapping(value = "/find-user-feed-back-list", produces = "application/json")
    public List<UserFeedBack> findUserFeedBackList() {
        return userFeedBackService.findUserFeedBackList();
    }
    @GetMapping(value = "/{userFeedBackId}", produces = "application/json")
    public UserFeedBack  findUserFeedBackList(@PathVariable Long userFeedBackId) {
        return userFeedBackService.findUserFeedBackById(userFeedBackId);
    }
}
