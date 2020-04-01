package com.demo.test;

import com.demo.config.DbDataHeleper;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @Author HuTing
 * @Date 2020-04-01 16:35
 */
public class TestDbData extends DbDataHeleper {

    /**
     * 连接数据库查询优惠券信息
     * @param param
     */
    @Test(dataProvider = "dbDataMethod")
    public void testmethod1(Map<?, ?> param) {
        System.out.println(param);
    }
}
