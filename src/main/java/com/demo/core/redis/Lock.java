package com.demo.core.redis;

import lombok.Data;

/**
 * 全局锁，包括锁的名称
 *
 * @author HuTing
 * @date 2020-05-13 11:08
 */
@Data
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
