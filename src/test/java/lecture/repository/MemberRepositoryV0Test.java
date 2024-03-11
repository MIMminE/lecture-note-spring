package lecture.repository;

import lecture.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10000);
        Member save = repositoryV0.save(member);
        log.debug((save.toString()));
    }
}