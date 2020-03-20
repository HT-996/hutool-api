package com.test.model;

import com.test.entity.CouponType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券
 *
 * @Author HuTing
 * @Date 2020-03-20 17:46
 */
@Data
@Entity
@Table(name = "coupons")
public class Coupons implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 优惠券标题
     */
    private String title;

    /**
     * 优惠券类型
     */
    @Enumerated(EnumType.STRING)
    private CouponType type;

    /**
     * 优惠券规则id
     */
    private Long ruleId;

    /**
     * 限制金额额度
     */
    private BigDecimal limitValue;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 有效天数
     */
    private Integer validDays;

    /**
     * 是否有效
     */
    private Boolean enabled;

    /**
     * 生效日期
     */
    private Date validAt;

    /**
     * 备注
     */
    private String remark;

    /**
     * 优惠券的唯一标识
     */
    private String sn;

    /**
     * 优惠券详情
     */
    private String description;

    /**
     * 资源id-商品ID、品类ID
     */
    private Long resourceId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 个人限领数量 默认 1
     */
    private Integer limitQuantity = 1;

    /**
     * 总数量
     */
    private Integer quantity;

    /**
     * 是否发布
     */
    private Boolean isDispatched;

    /**
     * 发布时间
     */
    private Date dispatchedTime;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
