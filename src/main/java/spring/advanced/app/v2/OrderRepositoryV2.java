package spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.advanced.trace.TraceId;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.tmpTrace.TmpTraceV2;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

    private final TmpTraceV2 trace;

    public void save(String itemId, TraceId traceId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.save()");

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
