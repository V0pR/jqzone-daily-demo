package com.core.domain;

import com.core.domain.finder.SessionFinder;
import io.ebean.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author v0pr
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session")
public class Session extends Model {

    public static final SessionFinder finder = new SessionFinder();

    @Id
    private String id;

    @Column
    private String accountId;

    @Column
    private Date expiredDate = new Date();
}
