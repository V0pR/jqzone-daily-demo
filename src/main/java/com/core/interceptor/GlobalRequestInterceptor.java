package com.core.interceptor;

import com.core.common.exception.SignatureException;
import com.core.common.utils.AESUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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

    @Value("${core.security.key1}")
    private String securityKey1;

    @Value("${core.security.key2}")
    private String securityKey2;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        START_TIME.set(System.currentTimeMillis());
        //checkSignature(request);
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

    private void checkSignature(HttpServletRequest request) throws Exception {
        String requestSignature = request.getHeader("sign");
        String data = request.getHeader("data");
        String key = securityKey1 + data + securityKey2;
        String signature = AESUtils.MD5(key.getBytes());
        if (!requestSignature.equals(signature)) {
            throw new SignatureException("无效的签名");
        }

    }
}
