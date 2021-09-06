package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = "+memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//memberService== memberServiceImpl의 인스턴스
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class); //이부분 달라짐
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//memberService== memberServiceImpl의 인스턴스
    }
    //인터페이스로 조회를 하면 인터페이스의 구현체가 조회됨

    @Test
    @DisplayName("구체 타입으로 조회")//구체로 조회는 가능하지만, 역할에 의존하고, 역할-구현을 구분해야하기 때문에 좋은 코드는 아님.
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); //구현체를 통해 조회해보기
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);//memberService== memberServiceImpl의 인스턴스
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        //ac.getBean("xxxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx", MemberService.class));
        //오른쪽 로직을 실행하면, 왼쪽의 예외가 실행되어야한다.
         }
}
