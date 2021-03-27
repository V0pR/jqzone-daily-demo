package com.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v0pr
 */
@RestController("indexController")
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/test")
    public String test(){
        return "i m test";
    }


}
