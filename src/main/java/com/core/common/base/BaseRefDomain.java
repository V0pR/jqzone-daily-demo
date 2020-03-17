package com.core.common.base;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import io.ebean.annotation.WhoCreated;
import io.ebean.annotation.WhoModified;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

/**
 * @author wjq
 * @version 1.0
 * @Title: BaseRefDomain
 * @Package com.core.common.base
 * @Description:
 * @date 2020/1/9 17:08
 */
@MappedSuperclass
@Data
public class BaseRefDomain {

    @Id
    private Long id;

    @Version
    private Long version;

    @WhenCreated
    private Timestamp whenCreated;

    @WhenModified
    private Timestamp whenModified;

    @WhoCreated
    private String whoCreated;

    @WhoModified
    private String whoModified;
}
