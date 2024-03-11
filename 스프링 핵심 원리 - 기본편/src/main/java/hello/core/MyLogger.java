package hello.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURI;

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURI + "]" + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create" + this);

    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close" + this);
    }
}
