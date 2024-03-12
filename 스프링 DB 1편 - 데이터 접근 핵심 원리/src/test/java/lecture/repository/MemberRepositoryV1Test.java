package lecture.repository;

import com.zaxxer.hikari.HikariDataSource;
import lecture.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static lecture.connection.ConnectionConst.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;

    @BeforeEach
    void beforeEach(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        repository = new MemberRepositoryV1(dataSource);
    }

    @Test
    void crud() throws SQLException {
        log.info("start");

        // save
        Member member = new Member("memberV0", 10000);
        repository.save(member);

        // findById
        Member memberById = repository.findById(member.getMemberId());
        Assertions.assertThat(memberById).isNotNull();

        // update: money: 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updatedMember.getMoney()).isEqualTo(20000);

        // delete
        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(()-> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}