package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class HelloData {
    private String username;
    private int age;
    private List<Integer> list;
}

