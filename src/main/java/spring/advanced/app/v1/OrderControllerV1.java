package spring.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.advanced.trace.TraceStatus;
import spring.advanced.trace.tmpTrace.TmpTraceV1;

@RequiredArgsConstructor
@RestController
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final TmpTraceV1 trace;

    @GetMapping("/v1/request")
//    public String request(@RequestParam("itemId") String itemId) {
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
