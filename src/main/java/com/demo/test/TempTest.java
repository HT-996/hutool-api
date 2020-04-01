package com.demo.test;

import com.demo.repository.CouponsRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author HuTing
 * @Date 2020-03-18 15:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TempTest {

    @Autowired
    private CouponsRepo couponsRepo;

    @Test
    public void test() {
        System.out.println("hello~");
        couponsRepo.findAll();
    }
}
