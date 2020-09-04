package com.demo.controller;

import com.demo.core.redis.AquiredLockWorker;
import com.demo.core.redis.DistributedLockHandler;
import com.demo.core.redis.DistributedLocker;
import com.demo.core.redis.Lock;
import com.demo.model.Members;
import com.demo.repository.MembersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author HuTing
 * @Date 2020-03-19 09:50
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DistributedLockHandler distributedLockHandler;
    @Autowired
    private DistributedLocker distributedLocker;
    @Autowired
    private MembersRepo membersRepo;

    @RequestMapping(value = "hello")
    public String hello() {
        logger.info("访问了hello方法");
        logger.debug("记录debug日志");
        logger.error("记录了error错误日志");
        return "Hello Word 之 Spring boot";
    }

    /**
     * 通过这种方式创建的分布式锁存在以下问题：
     * 高并发的情况下，如果两个线程同时进入循环，可能导致加锁失败。
     * SETNX 是一个耗时操作，因为它需要判断 Key 是否存在，因为会存在性能问题。
     *
     * @return
     */
    @RequestMapping("lock")
    public String lock() {
        Lock lock = new Lock("lynn", "min");
        if (distributedLockHandler.tryLock(lock)) {
            try {
                //为了演示锁的效果，这里睡眠5000毫秒
                System.out.println("执行方法");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            distributedLockHandler.releaseLock(lock);
        }
        return "hello lock!";
    }

    /**
     * Redlock是Redis 官方推荐的一种方案，因此可靠性比较高
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("redlock")
    public String redlock() throws Exception {
        distributedLocker.lock("test", new AquiredLockWorker<Object>() {
            @Override
            public Object invokeAfterLockAquire() {
                try {
                    System.out.println("执行方法！");
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

        });
        return "hello redlock!";
    }

    @RequestMapping("/findMembers")
    public List<Members> findMembers() {
        return membersRepo.findAll();
    }
}
