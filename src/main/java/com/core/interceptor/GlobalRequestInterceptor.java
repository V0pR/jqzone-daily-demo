package com.core.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author wangj
 * @version 1.0
 * @Title: GlobalRequestInterceptor
 * @Package com.core.interceptor
 * @Description: TODO
 * @date 2020/3/18 22:38
 */
@Component("globalRequestInterceptor")
public class GlobalRequestInterceptor extends HandlerInterceptorAdapter {
}
