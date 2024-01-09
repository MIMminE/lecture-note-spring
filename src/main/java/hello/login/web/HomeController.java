package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {
        log.info("visited {}", getClass());
        return "home";
    }

//    @GetMapping("/")
    public String homeLogin(
            @CookieValue(name = "memberId", required = false) Long memberId, Model model){

        if (memberId == null){
            return "home";
        }
        // 로그인
        Member loginMember = memberRepository.findById(memberId);
        if(loginMember == null){
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "login/loginHome";
    }

    @GetMapping("/")
    public String homeLoginArgumentResolver(@Login Member loginMember, Model model){

        // 세션에 회원 데이터가 없으면 home
        if (loginMember == null){
            return "home";
        }
    
        // 세션이 유지되어 있으면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
