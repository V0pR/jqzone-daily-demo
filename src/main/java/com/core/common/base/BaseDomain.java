package com.core.common.base;

import io.ebean.Model;
import io.ebean.annotation.DocProperty;
import io.ebean.annotation.JsonIgnore;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import io.ebean.annotation.WhoCreated;
import io.ebean.annotation.WhoModified;
import io.ebeaninternal.server.lib.util.Str;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

/**
 * @author wjq
 * @version 1.0
 * @Title: BaseDomain
 * @Package com.core.common.base
 * @Description: base domain
 * @date 2020/1/9 17:05
 */
@MappedSuperclass
@Data
public class BaseDomain extends Model {

    @Id
    @DocProperty(code = true, sortable = true)
    private Long id;

    @Version
    @JsonIgnore
    private Long version;

    @WhenCreated
    @DocProperty(code = true, sortable = true)
    private Timestamp whenCreated;

    @WhenModified
    @DocProperty(code = true, sortable = true)
    private Timestamp whenModified;

    @WhoCreated
    @DocProperty(code = true, sortable = true)
    private String whoCreated;

    @WhoModified
    @DocProperty(code = true, sortable = true)
    private String whoModified;

    @SoftDelete
    @JsonIgnore
    private boolean deleted;
}
