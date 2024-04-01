package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderRepository {

    public String save(String itemId){
        log.info("[orderRepository] 실행");

        // 저장 로직

        if(itemId.equals("ex")){
            throw new IllegalArgumentException("예외 발생!");
        }
        return "ok";
    }
}
