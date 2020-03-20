package com.test.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

/**
 * @Author HuTing
 * @Date 2020-03-19 10:43
 */
@Component
public class Query implements GraphQLQueryResolver {
    public String hello() {
        return "hello,graphql";
    }

    public String omg() {
        return "什么鬼！";
    }
}
