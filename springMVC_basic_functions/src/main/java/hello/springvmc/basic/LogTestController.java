package hello.springvmc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";

        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        //로그를 사용하지 않아도 a + b 계산 로직이 먼저 실행된다, 이런 방식은 사용하면 안된다.
        log.debug("String concat log = " + name);

        return "ok";
        //RestController 어노테이션을 사용했으므로 return 문자열을 통해 뷰 객체를 생성하지 않고
        //문자열을 바로 response 메시지로 보낸다.
    }
}
