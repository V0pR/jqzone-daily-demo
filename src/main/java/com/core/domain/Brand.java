package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: Brand
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:50
 */
@Entity
@Table
@Builder
public class Brand extends BaseDomain {

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌编码
     */
    private String code;


}
