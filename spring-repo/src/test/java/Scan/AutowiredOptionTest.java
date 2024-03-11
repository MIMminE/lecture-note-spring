package Scan;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredOptionTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }

        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }

        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }
    }
}
