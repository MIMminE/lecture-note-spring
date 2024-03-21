package study.spring.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.advanced.trace.HelloTraceV2;
import study.spring.advanced.trace.TraceId;
import study.spring.advanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final HelloTraceV2 trace;
    private final OrderRepositoryV2 orderRepository;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(traceId, itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
