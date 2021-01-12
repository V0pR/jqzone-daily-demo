package com.core.domain.finder;

import com.core.domain.Session;
import com.core.domain.query.QSession;
import io.ebean.Ebean;
import io.ebean.Finder;

import java.util.Date;

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
        return Ebean.find(Session.class)
                .where().idEq(sessionId)
                .and()
                .gt("expiredDate", new Date())
                .findOne();
    }
}
