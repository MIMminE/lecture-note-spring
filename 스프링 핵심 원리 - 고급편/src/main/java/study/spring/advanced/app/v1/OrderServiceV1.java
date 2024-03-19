package study.spring.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.advanced.trace.HelloTraceV1;
import study.spring.advanced.trace.TraceStatus;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final HelloTraceV1 trace;
    private final OrderRepositoryV1 orderRepository;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
