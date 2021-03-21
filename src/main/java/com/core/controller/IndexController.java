package com.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author v0pr
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 隐私政策
     * @return
     */
    @RequestMapping("/privacy-policy")
    public String privacyPolicy() {
        return "privacyPolicy";
    }

    /**
     * 用户协议
     * @return
     */
    @RequestMapping("/user-agreement")
    public String UserAgreement() {
        return "userAgreement";
    }

}
