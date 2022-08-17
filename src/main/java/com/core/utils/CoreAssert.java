package com.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import com.core.common.exception.BizException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author hongqiang.chang
 */
@UtilityClass
@Slf4j
public class CoreAssert {

    public static <T> T parseObject(String sourceJson, TypeReference<T> type, String errMsg) {
        if (Objects.isNull(sourceJson)) {
            throw new BizException("参数不能为空");
        } else {
            try {
                T t = JSON.parseObject(sourceJson, type);
                if (Objects.isNull(t)) {
                    log.error("参数转换异常");
                }
                return t;
            } catch (Exception e) {
                log.error(errMsg + "  " + e.getMessage(), e);
                throw new BizException(errMsg);
            }
        }
    }
}


