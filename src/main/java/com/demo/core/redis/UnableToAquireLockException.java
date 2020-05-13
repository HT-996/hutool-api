package com.demo.core.redis;

/**
 * 异常类
 *
 * @author HuTing
 * @date 2020-05-13 11:19
 */
public class UnableToAquireLockException extends RuntimeException {
    public UnableToAquireLockException() {
    }

    public UnableToAquireLockException(String message) {
        super(message);
    }

    public UnableToAquireLockException(String message, Throwable cause) {
        super(message, cause);
    }
}
