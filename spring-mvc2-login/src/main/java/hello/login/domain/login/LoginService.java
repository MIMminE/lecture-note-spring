package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;
    // MemberRepository 가 스프링 빈으로 등록되어 있으므로
    // 의존 관계 자동 주입 Autowired 기능에 의해 자동으로 저장소가 주입된다.

    /**
     * @return 로그인 성공 -> 해당 Member
     *         실패 -> null
     */
    public Member login(String loginId, String password){
        return memberRepository.findByLongId(loginId)
                .filter(m -> m.getLoginId().equals(password))
                .orElse(null);
    }
}


