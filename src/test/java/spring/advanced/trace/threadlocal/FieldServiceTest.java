package spring.advanced.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.advanced.trace.threadlocal.code.FieldService;
import spring.advanced.trace.threadlocal.code.ThreadLocalService;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();
    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA, "Thread-A");
        Thread threadB = new Thread(userB, "thread-B");

        threadA.start();
        sleep(2000);
        //Thread.sleep(100);
        threadB.start();

        sleep(2000);
    }

    @Test
    void threadLocalService() {
        log.info("main start");

        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA, "Thread-A");
        Thread threadB = new Thread(userB, "thread-B");

        threadA.start();
        sleep(2000);
//        sleep(100);
        threadB.start();

        sleep(2000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
