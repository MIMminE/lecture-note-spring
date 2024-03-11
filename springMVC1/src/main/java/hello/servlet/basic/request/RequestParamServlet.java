package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + req.getParameter(paramName)));

        System.out.println("[ 단일 파라미터 조회 ]");
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        PrintWriter writer = resp.getWriter();
        writer.write("OK");
    }
}
