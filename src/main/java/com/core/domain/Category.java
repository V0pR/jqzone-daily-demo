package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: Category
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/13 23:49
 */
@Entity
@Table
@Data
@Builder
public class Category extends BaseDomain {

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

}
