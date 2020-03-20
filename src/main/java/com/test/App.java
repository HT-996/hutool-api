package com.test;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

/** 启动类
 * @Author HuTing
 * @Date 2020-03-18 15:54
 */

@SpringBootApplication
@ServletComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("========start!========");
    }

//    @Bean
//    GraphQLSchema schema() {
//        return GraphQLSchema.newSchema()
//                .query(GraphQLObjectType.newObject()
//                        .name("query")
//                        .field(field -> field
//                                .name("test")
//                                .type(Scalars.GraphQLString)
//                                .dataFetcher(environment -> "response")
//                        )
//                        .build())
//                .build();
//    }

//    @Bean
//    @ConditionalOnBean({SchemaParser.class})
//    @ConditionalOnMissingBean({GraphQLSchema.class, GraphQLSchemaProvider.class})
//    public GraphQLSchema graphQLSchema(SchemaParser schemaParser) {
//        return schemaParser.makeExecutableSchema();
//    }
}
