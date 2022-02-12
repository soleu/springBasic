package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = memberService.getMemberRepository();
        //3가지 다 같은 인스턴스 조회(공유 되어 사용)
        //new로 같은 레포지토리가 호출되어도, @Confiuration -> AppConfig
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs((memberRepository));
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        //스프링 빈을 등록하는 과정에서 바이트코드 조작 라이프러리를 사용하여 임의의 다른 클래스를 만들고, 그 클래스를 스프링 빈으로 등록
        // => 싱글톤을 보장하기 위해 (@Configuration - AppConfig 를 사용하여야 이와 같은 조작을 함)
        //bean.getClass() = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$3f9a2c2d
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
