package autowired.annotation.componetTestClass;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainInstance")
public class TestInstanceA implements TestInterface{
}
