package hello.servlet.web.frontcontroller.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paraMap) {
        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");

        mv.getModel().put("members", members);

        return mv;
    }
}
