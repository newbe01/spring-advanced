package spring.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.strategy.code.strategy.ContextV1;
import spring.advanced.trace.strategy.code.strategy.Strategy;
import spring.advanced.trace.strategy.code.strategy.StrategyLogic1;
import spring.advanced.trace.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // biz logic st
        log.info("비즈니스 로직1 실행");
        // biz logic ed
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // biz logic st
        log.info("비즈니스 로직2 실행");
        // biz logic ed
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime : {}", resultTime);
    }

    @Test
    void strategyV1() {
        StrategyLogic1 logic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(logic1);
        context1.execute();

        StrategyLogic2 logic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(logic2);
        context2.execute();

    }

    @Test
    void strategyV2() {
        Strategy strategy1 = new Strategy() {

            @Override
            public void call() {
                log.info("logic 1");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        Strategy strategy2 = new Strategy() {

            @Override
            public void call() {
                log.info("logic 2");
            }
        };

        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();

        log.info("strategy1 : {}", strategy1.getClass());
        log.info("strategy2 : {}", strategy2.getClass());

    }

    @Test
    void strategyV3() {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("logic 1");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("logic 2");
            }
        });

        contextV2.execute();
    }

    @Test
    void strategyV4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("logic 1"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("logic 2"));
        contextV2.execute();
    }
}
