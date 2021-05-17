package com.core.advice;


import com.core.DemoCode.ApiTimeLog;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author v0pr
 */
@Import({ApiTimeLog.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ApiTimeLogAspect {
}
