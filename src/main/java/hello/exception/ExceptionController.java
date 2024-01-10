package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

    @GetMapping("test-ex")
    public void error(){
        throw new TestException("test Exception");
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    static class TestException extends RuntimeException{
        public TestException(String message) {
            super(message);
        }
    }
}
