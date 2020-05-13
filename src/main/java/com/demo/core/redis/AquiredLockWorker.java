package com.demo.core.redis;

/**
 * 获取锁后需要处理的逻辑
 *
 * @author HuTing
 * @date 2020-05-13 11:17
 */
public interface AquiredLockWorker<T> {
    /**
     * 获取锁后
     *
     * @return
     * @throws Exception
     */
    T invokeAfterLockAquire() throws Exception;
}
