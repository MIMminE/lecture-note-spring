package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3{
    @Override
    public ModelView process(Map<String, String> paraMap) {
        //  단순하게 뷰를 호출하는 목적으로 사용되는 컨트롤러이다.
        return new ModelView("new-form");
        // 단, 여기서 전체 URI 경로가 아닌 논리 이름으로 작성한다.
        // 프론트 컨트롤러에서 논리 이름을 물리 경로로 변환할 것이다.
    }
}
