package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.CoffeeOrderStatus;
import io.ebeaninternal.server.lib.util.Str;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author wangj
 * @version 1.0
 * @Title: CoffeeOrder
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:47
 */
@Entity
@Table(name = "coffee_order")
@Builder
public class CoffeeOrder extends BaseDomain {

    /**
     * 订单用户
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @Column(nullable = false)
    private User user;

    /**
     * 商品
     */
    @ManyToOne(targetEntity = Coffee.class)
    @JoinColumn(name = "coffee_id")
    @Column(nullable = false)
    private Coffee coffee;


    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private CoffeeOrderStatus status;


    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单完成时间
     */
    private LocalDateTime doneTime;

    /**
     * 取消时间
     */
    private LocalDateTime cancelTime;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;


}
