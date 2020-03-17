package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wangj
 * @version 1.0
 * @Title: Role
 * @Package com.core.domain
 * @Description: TODO
 * @date 2020/3/17 22:22
 */
@Entity
@Table
@Data
@Builder
public class Role extends BaseDomain {

    /**
     * 名字
     */
    private String name;

    /**
     * code
     */
    private String code;
}
