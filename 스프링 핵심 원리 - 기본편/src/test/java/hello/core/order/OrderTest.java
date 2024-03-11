package hello.core.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testToString() {
        Order order = new Order(1L,"TestName", 1000, 100);
        System.out.println("order = " + order);
    }
}