package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HuTing
 * @Date 2020-03-19 09:50
 */
@RestController
public class HelloController {
    @RequestMapping(value = "hello")
    public String hello() {
        return "Hello Word 之 Spring boot";
    }
}
