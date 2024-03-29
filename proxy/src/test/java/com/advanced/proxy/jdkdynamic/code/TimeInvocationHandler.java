package com.advanced.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("call timeProxy");

        long st = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long ed = System.currentTimeMillis();

        long resultTime = ed - st;
        log.info("end timeProxy, resultTime : {}", resultTime);

        return result;
    }
}
