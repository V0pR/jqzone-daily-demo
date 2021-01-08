package com.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.util.Enumeration;

/**
 * @author wangj
 * @version 1.0
 * @Title: GlobalRequestInterceptor
 * @Package com.core.interceptor
 * @Description:
 * @date 2020/3/18 22:38
 */
@Component("globalRequestInterceptor")
public class GlobalRequestInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        START_TIME.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String uri = request.getRequestURI();
        String method = request.getMethod();

        StringBuffer headerBuffer = new StringBuffer();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            headerBuffer.append("[").append(name).append(",").append(request.getHeader(name)).append("]");
        }
        long time = System.currentTimeMillis() - START_TIME.get();
        logger.info("uri: {}, method: {},headers:{}, time:{}", uri, method, headerBuffer.toString(), time);

        START_TIME.remove();
        super.postHandle(request, response, handler, modelAndView);
    }
}
