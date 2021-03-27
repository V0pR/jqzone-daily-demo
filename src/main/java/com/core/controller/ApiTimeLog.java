package com.core.controller;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class ApiTimeLog {

    @Pointcut("execution(* com.core.controller.*.*(..))")
    public void controllerPointcut() {
        System.out.println("我是一个切面的开始");
    }

    @Around("controllerPointcut()")
    private Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        //这里目测是用动态代理的方式实现
        Object proceed = proceedingJoinPoint.proceed();
        log.info("------------ 耗时: {} ms ------------", System.currentTimeMillis() - startTimeMillis);
        return proceed;

    }
}
