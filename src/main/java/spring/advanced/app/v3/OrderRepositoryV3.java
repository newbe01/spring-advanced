package spring.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception");
            }

            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
