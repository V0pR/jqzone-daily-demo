package com.core.domain;

import com.core.common.base.BaseDomain;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wjq
 * @version 1.0
 * @Title: Role
 * @Package com.core.domain
 * @Description: 角色
 * @date 2020/1/16 16:17
 */
@Entity
@Builder
@Data
@Table(name = "role")
public class Role extends BaseDomain {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    @Column(columnDefinition = "TEXT")
    private String description;
}
