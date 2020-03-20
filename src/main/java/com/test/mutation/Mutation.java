package com.test.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

/**
 * @Author HuTing
 * @Date 2020-03-19 10:46
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    public String hello() {
        return "hello,graphql mutation!";
    }
}
