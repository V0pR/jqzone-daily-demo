package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.domain.enums.CoffeeStatus;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    private Category category;

    /**
     * 品牌
     */
    private Brand brand;
}
