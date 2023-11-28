package hello.core.order;

import hello.core.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;

    @Override
    public void order() {

    }
    
    //테스트 용도로만 사용하는 get 메소드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public OrderServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
