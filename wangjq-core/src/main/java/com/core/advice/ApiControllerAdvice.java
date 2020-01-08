package com.core.advice;

import com.alibaba.fastjson.JSONObject;
import com.core.exception.BizException;
import com.core.exception.SessionException;
import com.core.exception.SignatureException;
import com.inmeijia.domain.ResultWrapper;
import io.ebean.PagedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

;

/**
 * Created by rocky on 2017/07/10.
 */
@RestControllerAdvice(annotations = {RestController.class})
public class ApiControllerAdvice implements ResponseBodyAdvice {

    private final static Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResultWrapper handler(Exception exception, HttpServletRequest request) {
        logger.error("url:{},params:{}", request.getRequestURL(), JSONObject.toJSONString(request.getParameterMap()));
        logger.error(exception.getMessage(), exception);
        return ResultWrapper.error(500, exception.getMessage());
    }

    @ExceptionHandler(value = BizException.class)
    public ResultWrapper handlerBizException(BizException bizException, HttpServletRequest request) {
        logger.error("url:{},params:{},message:{}", request.getRequestURL(), JSONObject.toJSONString(request.getParameterMap()), bizException.getMessage());
        return ResultWrapper.error(510, bizException.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResultWrapper handlerAccessDeniedException(AccessDeniedException exception, HttpServletRequest request) {
        logger.error("url:{},params:{},message:{}", request.getRequestURL(), JSONObject.toJSONString(request.getParameterMap()), exception.getMessage());
        return ResultWrapper.error(520, exception.getMessage());
    }

    @ExceptionHandler(value = SignatureException.class)
    public ResultWrapper handlerSignatureException(SignatureException exception, HttpServletRequest request) {
        logger.error("url:{},params:{},message:{}", request.getRequestURL(), JSONObject.toJSONString(request.getParameterMap()), exception.getMessage());
        return ResultWrapper.error(530, exception.getMessage());
    }

    @ExceptionHandler(value = SessionException.class)
    public ResultWrapper handlerSignatureException(SessionException exception, HttpServletRequest request) {
        logger.error("url:{},params:{},message:{}", request.getRequestURL(), JSONObject.toJSONString(request.getParameterMap()), exception.getMessage());
        return ResultWrapper.error(540, exception.getMessage());
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (methodParameter.hasMethodAnnotation(NotWrapper.class)) {
            return false;
        }

        if (methodParameter.getMethod().getDeclaringClass().getName().startsWith("com.zqt.api")) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (body instanceof ResultWrapper) {
            return body;
        }

        if (body instanceof PagedList) {
            PagedList pagedList = (PagedList) body;

            ResultWrapper.PagedList module = new ResultWrapper.PagedList();
            module.setList(pagedList.getList());
            module.setPageIndex(pagedList.getPageIndex() + 1);
            module.setPageSize(pagedList.getPageSize());
            module.setTotalCount(pagedList.getTotalCount());
            module.setTotalPageCount(pagedList.getTotalPageCount());
            body = module;
        }

        ResultWrapper resultWrapper = ResultWrapper.valueOf(body);
        return resultWrapper;
    }


}
