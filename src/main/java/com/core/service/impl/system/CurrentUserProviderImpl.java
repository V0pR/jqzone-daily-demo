package com.core.service.impl.system;

import com.core.domain.User;
import io.ebean.config.CurrentUserProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author rocky.lxl
 * @version 1.0
 * @Package com.inmeijia.service.impl
 * @Description: ebean CurrentUserProvider
 * @date 2019/5/8 3:04 PM
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
        if (null == SecurityContextHolder.getContext().getAuthentication()) {
            return "SYSTEM";
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return ((User) principal).getName();
        }
        return principal.toString();
    }

}
