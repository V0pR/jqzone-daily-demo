package com.core.domain.finder;

import com.core.domain.Session;
import com.core.domain.query.QSession;
import io.ebean.Ebean;
import io.ebean.Finder;

import java.util.Date;
import java.util.Optional;

public class SessionFinder extends Finder<Long, Session> {
    public SessionFinder() {
        super(Session.class);
    }

    public SessionFinder(String databaseName) {
        super(Session.class, databaseName);
    }

    public QSession queryBean() {
        return new QSession(db());
    }


    public Session findById(String sessionId) {
        return this.queryBean()
                .where()
                .id.eq(sessionId)
                .expiredDate.gt(new Date())
                .findOne();
    }

    public Optional<Session> findOneOrEmpty(String sessionId) {
        return this.queryBean()
                .where()
                .id.eq(sessionId)
                .expiredDate.gt(new Date())
                .findOneOrEmpty();
    }

    public Optional<Session> findOneOrEmptyByAccount(String account) {
        return this.queryBean()
                .where()
                .accountId.eq(account)
//                .expiredDate.gt(new Date())
                .findOneOrEmpty();
    }
}
