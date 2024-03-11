package hello.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class ExceptionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(ExceptionApplication.class, args);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info(beanDefinitionName);
        }

    }

}
