package com.core.interceptor;

import com.core.common.exception.BizException;
import com.core.common.exception.SessionException;
import com.core.domain.User;
import com.core.domain.Session;
import com.core.domain.enums.EmployeeStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

/**
 * @author v0pr
 */
@Component("loginRequestInterceptor")
public class LoginRequestInterceptor extends HandlerInterceptorAdapter {

    private static final long EXPIRED_MILLIS = 7 * 24 * 60 * 60 * 1000L;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = request.getHeader("sessionKey");
        if (StringUtils.isBlank(sessionId)) {
            sessionId = request.getParameter("sessionKey");
        }


        if (StringUtils.isBlank(sessionId)) {
            throw new SessionException("请先登录");
        }

        Session session = Session.finder.findById(sessionId);
        if (null == session) {
            throw new SessionException("登录过期,请重新登录");
        }

        Optional<User> optional = User.finder.findByUserId(session.getAccountId());
        if (!optional.isPresent()) {
            throw new BizException("欢迎使用wangjqDemo项目，请先加入系统");
        }
        User employee = optional.get();
        session.setAccountId(employee.getAccount());
        session.setExpiredDate(new Date(System.currentTimeMillis() + EXPIRED_MILLIS));
        session.update();

        if (null != employee) {
            if (!EmployeeStatus.NORMAL.equals(employee.getStatus())) {
                throw new BizException("非正常账户不可登录");
            }
        }
        request.setAttribute("AID", employee.getAccount());
        request.setAttribute("EID", employee.getId());
        return super.preHandle(request, response, handler);
    }
}
