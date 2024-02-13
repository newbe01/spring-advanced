package com.advanced.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component {

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("call timeDecorator");
        long start = System.currentTimeMillis();

        String result= component.operation();

        long end = System.currentTimeMillis();
        log.info("resultTime : {}ms ", end - start);
        return result;
    }
}
