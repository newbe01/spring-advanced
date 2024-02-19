package com.advanced.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("call timeProxy");

        long st = System.currentTimeMillis();

        Object result = invocation.proceed();

        long ed = System.currentTimeMillis();

        long resultTime = ed - st;
        log.info("end timeProxy, resultTime : {}", resultTime);

        return result;
    }
}
