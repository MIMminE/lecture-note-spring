package lecture.repository;

import lecture.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional // 테스트 이후 롤백을 위한 작업
class MemberRepositoryV0Test {

    MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member member = new Member("memberV0", 10000);
        Member save = repositoryV0.save(member);
        log.debug((save.toString()));

        // findById
        Member findMember = repositoryV0.findById(member.getMemberId());
        log.debug("findMember={}",findMember);
        Assertions.assertThat(findMember).isEqualTo(member);

        // update
        repositoryV0.update(member.getMemberId(), 20000);
        Member updateMember = repositoryV0.findById(member.getMemberId());
        log.debug("updateMember={}",updateMember);
        Assertions.assertThat(updateMember.getMoney()).isEqualTo(20000);

        // delete
        repositoryV0.delete(member.getMemberId());
        Assertions.assertThatThrownBy(()-> repositoryV0.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);

    }

}