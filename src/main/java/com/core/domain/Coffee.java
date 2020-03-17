package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.CoffeeStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author wangj
 * @version 1.0
 * @Title: Coffee
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 22:39
 */
@Entity
@Builder
@Table
@Data
public class Coffee extends BaseDomain {


    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 商品状态
     */
    private CoffeeStatus status;


    /**
     * 商品类型
     */
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    @Column(nullable = false)
    private Category category;

    /**
     * 品牌
     */
    @ManyToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand_id")
    @Column(nullable = false)
    private Brand brand;
}
