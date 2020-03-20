package com.test.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author HuTing
 * @Date 2020-03-20 15:27
 */
@Configuration
@ConfigurationProperties(prefix = "graphql.servlet")
public class GraphQLServletProperties {
    private String mapping;

    public String getMapping() {
        return mapping != null ? mapping : "/graphql";
    }

    //省略
}
