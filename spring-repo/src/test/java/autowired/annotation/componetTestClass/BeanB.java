package autowired.annotation.componetTestClass;

import org.springframework.stereotype.Component;

@Component
public class BeanB implements BeanInterface{
    @Override
    public void test() {
        System.out.println("BeanB.test");
    }

    public BeanB() {
    }
}
