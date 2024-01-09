package spring.advanced.trace.tmpTrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

class TmpTraceV2Test {

    @Test
    void begin_end() {
        TmpTraceV2 trace = new TmpTraceV2();
        TraceStatus status1 = trace.begin("tmp");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "tmp2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        TmpTraceV2 trace = new TmpTraceV2();
        TraceStatus status1 = trace.begin("tmp");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "tmp");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}