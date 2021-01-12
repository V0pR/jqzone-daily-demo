package com.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v0pr
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @GetMapping(value = "/{employeeId}")
    public Map login() {
        Map map = new HashMap();
        map.put("1","我是测试测试");
        return map;
    }

}
