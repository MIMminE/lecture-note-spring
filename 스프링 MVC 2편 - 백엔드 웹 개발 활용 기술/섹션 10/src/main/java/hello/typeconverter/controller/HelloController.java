package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/hello-v3")
    public String helloV3(@ModelAttribute UserData userData){
        System.out.println("userData = " + userData);
        return "ok";
    }

    @GetMapping("/hello-v4/{value}")
    public String helloV4(@PathVariable Integer value){
        System.out.println("value = " + value);
        return "ok";
    }

    @GetMapping("/convert-ip-port")
    public String convertIpPort(@ModelAttribute IpPort ipPort){
        System.out.println("ipPort.getPort() = " + ipPort.getPort());
        System.out.println("ipPort.getIp() = " + ipPort.getIp());
        return "ok";
    }

    @Data
    static class UserData{
        Integer data;
    }
}
