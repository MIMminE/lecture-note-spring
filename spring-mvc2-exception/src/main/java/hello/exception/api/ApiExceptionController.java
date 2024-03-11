package hello.exception.api;

import hello.exception.exception.BadReqestException;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiExceptionController {

    @GetMapping("/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }
        if (id.equals("bad")) {
            throw new BadReqestException();
        }
        return new MemberDto(id, "hello " + id);
    }

    @GetMapping("/response-status-ex2")
    public String responseStatus() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
    }

    @GetMapping("/default-handler-ex")
    public String defaultException(@RequestParam Integer data) {
        return "ok";
    }

    // DTO는 데이터 전송 계층의 역할로 데이터를 간소화하여 전송하기 위한 목적에서 사용되는 오브젝트
    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
