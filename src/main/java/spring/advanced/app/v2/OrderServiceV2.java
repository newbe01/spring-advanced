package spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.advanced.trace.TraceId;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.tmpTrace.TmpTraceV2;

@RequiredArgsConstructor
@Service
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final TmpTraceV2 trace;

    public void orderItem(String itemId, TraceId traceId) {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(itemId, status.getTraceId());
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
