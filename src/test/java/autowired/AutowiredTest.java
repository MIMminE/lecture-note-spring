package autowired;

import autowired.annotation.AutowiredTestAppConfig;
import autowired.annotation.componetTestClass.BeanA;
import autowired.annotation.componetTestClass.BeanInterface;
import autowired.annotation.componetTestClass.TestInterface;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void qualifierTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredTestAppConfig.class);

        BeanA bean = ac.getBean("beanA",BeanA.class);
        System.out.println("bean = " + bean);
        TestInterface instance = bean.getInstanceA();
        System.out.println("instance = " + instance);

    }
}
