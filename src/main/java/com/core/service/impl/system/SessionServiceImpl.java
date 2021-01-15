package com.core.service.impl.system;

import com.core.domain.Session;
import com.core.service.SessionService;
import io.ebean.DB;
import io.ebean.Ebean;
import org.springframework.stereotype.Service;

/**
 * @author v0pr
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Override
    public void create(Session session) {
        Ebean.insert(session) ;
    }

    @Override
    public void update(Session session) {
        Ebean.update(session);
    }
}
