package com.core.common.base;

import io.ebean.Model;
import io.ebean.annotation.DocProperty;
import io.ebean.annotation.JsonIgnore;
import io.ebean.annotation.SoftDelete;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public Timestamp getWhenModified() {
        return whenModified;
    }

    public void setWhenModified(Timestamp whenModified) {
        this.whenModified = whenModified;
    }

    public String getWhoCreated() {
        return whoCreated;
    }

    public void setWhoCreated(String whoCreated) {
        this.whoCreated = whoCreated;
    }

    public String getWhoModified() {
        return whoModified;
    }

    public void setWhoModified(String whoModified) {
        this.whoModified = whoModified;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
