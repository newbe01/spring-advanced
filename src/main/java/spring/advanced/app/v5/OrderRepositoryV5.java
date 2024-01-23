package spring.advanced.app.v5;

import org.springframework.stereotype.Repository;
import spring.advanced.trace.callback.TraceTemplate;
import spring.advanced.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }


    public void save(String itemId) {

        template.execute("OrderRepository.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("Exception");
            }
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
