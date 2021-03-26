package com.core.service.system;

import io.ebean.config.CurrentUserProvider;
import org.springframework.stereotype.Service;

/**
 * @author wjq
 */
@Service("currentUserProvider")
public class CurrentUserProviderImpl implements CurrentUserProvider {

    /**
     * 如果会话没有用户，返回系统用户
     * 如果是 account，返回 nick
     * 如果是 employee，返回 name
     *
     * @return
     */
    @Override
    public Object currentUser() {
        return "SYSTEM";
    }

}
