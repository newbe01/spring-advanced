package spring.advanced.trace.strategy.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        // biz logic st
        callback.call();
        // biz logic ed
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);
    }
}
