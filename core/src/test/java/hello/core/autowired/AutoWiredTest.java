package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    // 호출 안됨
    @Test
    void AutoWiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("noBean1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("noBean2 = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 = " + member);
        }

    }
}
