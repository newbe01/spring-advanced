package com.advanced.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection() {

        Tmp target = new Tmp();

        log.info("start");
        String result1 = target.callA();
        log.info("result : {}" , result1);

        log.info("start");
        String result2 = target.callB();
        log.info("result : {}" , result2);

    }

    @Test
    void reflectionTest1() throws Exception {
        Class classTmp = Class.forName("com.advanced.proxy.jdkdynamic.ReflectionTest$Tmp");

        Tmp target = new Tmp();

        Method methodCallA = classTmp.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1 : {}", result1);

        Method methodCallB = classTmp.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2 : {}", result2);

    }

    @Test
    void reflection2() throws Exception {
        Class classTmp = Class.forName("com.advanced.proxy.jdkdynamic.ReflectionTest$Tmp");

        Tmp target = new Tmp();

        Method methodCallA = classTmp.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classTmp.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result : {}" , result);
    }

    @Slf4j
    static class Tmp {
        public String callA() {
            log.info("call A");
            return "A";
        }

        public String callB() {
            log.info("call B");
            return "B";
        }

    }
}
