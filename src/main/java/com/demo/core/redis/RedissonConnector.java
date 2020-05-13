package com.demo.core.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取RedissonClient连接类
 *
 * @author HuTing
 * @date 2020-05-13 11:19
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;

    @PostConstruct
    public void init() {
        redisson = Redisson.create();
    }

    public RedissonClient getClient() {
        return redisson;
    }
}
