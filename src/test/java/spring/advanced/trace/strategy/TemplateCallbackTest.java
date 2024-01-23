package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.template.Callback;
import spring.advanced.trace.strategy.template.TimeLogTemplate;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("logic 1");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("logic 2");
            }
        });
    }

    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("logic 1"));
        template.execute(() -> log.info("logic 2"));
    }

}
