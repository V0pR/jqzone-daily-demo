package com.core.controller;

import com.core.domain.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

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


    @GetMapping("/response")
    public Response response(){
        return new Response();
    }
}
