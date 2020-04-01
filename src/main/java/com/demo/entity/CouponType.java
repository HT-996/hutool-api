package com.demo.entity;

/**
 * 优惠券
 *
 * @Author HuTing
 * @Date 2020-03-20 17:50
 */
public enum CouponType {
    /**
     * 单品券
     */
    SINGLE_PRODUCT("SINGLE_PRODUCT", "单品券"),
    /**
     * 商品类目券
     */
    CATEGORY_PRODUCT("CATEGORY_PRODUCT", "商品类目券"),
    /**
     * 代金券
     */
    CASH("CASH", "代金券");

    private final String type;
    private final String name;

    CouponType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return type;
    }

    public String getTypeCn() {
        return name;
    }
}
