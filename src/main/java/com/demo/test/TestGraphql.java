package com.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.demo.App;
import com.demo.model.Coupons;
import com.demo.repository.CouponsRepo;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import utils.ExceptionUtil;
import utils.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HuTing
 * @Date 2020-04-02 11:14
 */
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)

//设置事务不回滚,springbootTest事务默认自动回滚
//@Transactional
//@Rollback(false)
public class TestGraphql extends AbstractTestNGSpringContextTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CouponsRepo couponsRepo;
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testcase1() {
        System.err.println("<<<<<<==============================================================================================>>>>>>");
        List<Coupons> list = null;
        HttpResponse response = null;
        String thirdPartyIFPayApiUrl = "http://127.0.0.1:6001";
        try {
            logger.info("开始测试--->>>");

            //redis调用
            System.err.println("redis Data: " + redisTemplate.hasKey("name"));
//            RedisClient client = RedisClient.create(redisURI);


            list = getDate();

            Map<String, String> requestParams = new HashMap<>(3);
            String query = "{findAllCoupons{id,title,typeCn}}";
            requestParams.put("query", query);
            requestParams.put("operationName", "");
            requestParams.put("variables", "{}");
            HashMap<String, String> headers = new HashMap<>(1);
            headers.put("Content-Type", "application/json");
            response = HttpUtil.doPost(thirdPartyIFPayApiUrl, "/graphql", headers, null, JSONObject.toJSONString(requestParams));
            String string = EntityUtils.toString(response.getEntity());
//            System.out.println("list1: "+(list!=null?list.toString():null));
            System.out.println("response:  " + string.toString());
            JSONObject result = JSONObject.parseObject(string);
            System.out.println("请求返回数据: " + result.toJSONString());
        } catch (Exception e) {
            logger.debug("异常信息:{}", ExceptionUtil.getStackMsg(e));
        }
        System.err.println("<<<<<<==============================================================================================>>>>>>");

    }

    private List<Coupons> getDate() {
        return couponsRepo.findAll();
    }

   /* assertTrue 判断是否为true。
    assertFalse 判断是否为false。
    assertSame 判断引用地址是否相等。
    assertNotSame 判断引用地址是否不相等。
    assertNull 判断是否为null
    assertNotNull 判断是否不为null
    assertEquals 判断是否相等，Object类型的对象需要实现hashCode及equals方法，集合类型Collection/Set/Map 中的对象也需要实现hashCode及equals方法，3个double参数时比较好玩，前两个double相等，或者前两个double的差值小于传入的第三个double值，即偏移量小于多少时，认为相等。
    assertNotEquals 判断是否不相等
    assertEqualsNoOrder 判断忽略顺序是否相等*/
}
