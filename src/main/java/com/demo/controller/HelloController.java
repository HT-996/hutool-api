package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HuTing
 * @Date 2020-03-19 09:50
 */
@RestController
public class HelloController {

    /**
     * logback
     */
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "hello")
    public String hello() {
        logger.info("访问了hello方法");
        logger.debug("记录debug日志");
        logger.error("记录了error错误日志");
        return "Hello Word 之 Spring boot";
    }
}
