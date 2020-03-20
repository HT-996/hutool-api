package com.test.query.coupons;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.test.model.Coupons;
import com.test.repository.CouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author HuTing
 * @Date 2020-03-20 18:03
 */
@Component
public class CouponsQuery implements GraphQLQueryResolver {
    @Autowired
    private CouponsRepo couponsRepo;

    public List<Coupons> findAllCoupons() {
        return couponsRepo.findAll();
    }
}
