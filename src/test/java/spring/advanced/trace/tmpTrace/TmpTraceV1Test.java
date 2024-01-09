package spring.advanced.trace.tmpTrace;

import org.junit.jupiter.api.Test;
import spring.advanced.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class TmpTraceV1Test {

    @Test
    void begin_end() {
        TmpTraceV1 trace = new TmpTraceV1();
        TraceStatus status = trace.begin("tmp");
        trace.end(status);
    }

    @Test
    void begin_exception() {
        TmpTraceV1 trace = new TmpTraceV1();
        TraceStatus status = trace.begin("tmp");
        trace.exception(status, new IllegalStateException());
    }
}