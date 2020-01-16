package com.core.domain;

import com.core.common.base.BaseDomain;
import com.core.common.base.BaseRefDomain;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.lang.ref.PhantomReference;

/**
 * @author wjq
 * @version 1.0
 * @Title: userRoleRef
 * @Package com.core.domain
 * @Description:
 * @date 2020/1/16 16:20
 */
@Data
@Builder
@Entity
@Table(name = "user_role_ref",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})})
public class UserRoleRef extends BaseRefDomain {

    /**
     * 用户
     */
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    /**
     * 角色
     */
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(nullable = false, name = "role_id")
    private Role role;

    /**
     * 备注
     */
    private String remark;

}
