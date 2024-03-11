package autowired;

import autowired.annotation.AutowiredTestAppConfig;
import autowired.annotation.componetTestClass.TestInterface;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AllBeanTestConfig.class, AutowiredTestAppConfig.class);
        AllBeanTestConfig test = ac.getBean(AllBeanTestConfig.class);
        TestInterface a = test.get("testInstanceA");
        System.out.println("a = " + a);

    }

    static class AllBeanTestConfig{
        private final Map<String, TestInterface> instacneMap;
        private final List<TestInterface> instanceList;

        public AllBeanTestConfig(Map<String, TestInterface> instacneMap, List<TestInterface> instanceList) {
            this.instacneMap = instacneMap;
            this.instanceList = instanceList;
                        for (TestInterface value : instacneMap.values()) {
                System.out.println("value = " + value);
            }
        }

        public TestInterface get(String Code){
            return instacneMap.get(Code);
        }
    }
}
