package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 *
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
//                                .name("demo")
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
