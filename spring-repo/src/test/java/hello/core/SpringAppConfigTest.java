package hello.core;

import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SpringAppConfigTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Spring Bean 조회하기 : MeberService")
    void memberService() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    @DisplayName("Spring Bean 조회하기 : OrderService")
    void orderService() {
        OrderService orderService = ac.getBean(OrderService.class);
        assertThat(orderService).isInstanceOf(OrderService.class);

    }
}