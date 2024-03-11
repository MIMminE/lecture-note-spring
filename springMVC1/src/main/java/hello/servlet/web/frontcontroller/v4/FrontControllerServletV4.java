package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {
    // 핸들러 매핑 정보 작성
    Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        Map<String, Object> model = new HashMap<>();

        // 핸들러 매핑
        String requestURI = request.getRequestURI();
        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            System.out.println("TESTING");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 핸들러 로직 수행
        String viewName = controller.process(paramMap, model);
        System.out.println("viewName = " + viewName);
        // 뷰 호출
        MyView myView = viewResolver(viewName);
        myView.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}


