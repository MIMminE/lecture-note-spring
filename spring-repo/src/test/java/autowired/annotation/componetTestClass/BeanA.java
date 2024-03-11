package autowired.annotation.componetTestClass;

import autowired.annotation.mainInstance;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements BeanInterface{

    private final TestInterface instanceA;

    public TestInterface getInstanceA() {
        return instanceA;
    }

    @Override

    public void test() {
        System.out.println("BeanA.test");
    }

    public BeanA(@mainInstance TestInterface instanceA) {
        this.instanceA = instanceA;
    }
}
