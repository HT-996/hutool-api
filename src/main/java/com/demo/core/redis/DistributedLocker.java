package com.demo.core.redis;

/**
 * 获取锁管理类
 *
 * @author HuTing
 * @date 2020-05-13 11:18
 */
public interface DistributedLocker {

    /**
     * 获取锁
     *
     * @param resourceName 锁的名称
     * @param worker       获取锁后的处理类
     * @param <T>
     * @return 处理完具体的业务逻辑要返回的数据
     * @throws UnableToAquireLockException
     * @throws Exception
     */
    <T> T lock(String resourceName, AquiredLockWorker<T> worker) throws UnableToAquireLockException, Exception;

    /**
     * 获取锁
     * @param resourceName
     * @param worker
     * @param lockTime
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T lock(String resourceName, AquiredLockWorker<T> worker, int lockTime) throws Exception;
}
