package com.demo.query.coupons;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.model.Coupons;
import org.springframework.stereotype.Component;

/**
 * @Author HuTing
 * @Date 2020-04-02 13:36
 */
@Component
public class CouponTypeResolver implements GraphQLResolver<Coupons> {

    /**
     * 优惠券类型
     *
     * @param coupon
     * @return
     */
    public String typeCn(Coupons coupon) {
        return coupon.getType().getTypeCn();
    }
}
