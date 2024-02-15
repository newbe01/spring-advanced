package com.advanced.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("call timeProxy");

        long st = System.currentTimeMillis();

        Object result = proxy.invoke(target, args);

        long ed = System.currentTimeMillis();
        long resultTime = ed - st;
        log.info("end timeProxy, resultTime : {}", resultTime);

        return result;
    }
}
