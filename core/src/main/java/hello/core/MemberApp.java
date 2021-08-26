package hello.core;

import hello.core.member.Member;
import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp { //순수 자바로 테스트 하는 방법
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
        // MemberService memberService=new MemberServiceImpl();
//        MemberService memberService= appConfig.memberService();//이런식으로 appConfig를 이용하여 Service 메서드를 사용한다

        //스프링은 모든 것을 `ApplicationContext`를 지향함(=스프링 컨테이너, Bean 관리)
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AppConfig.class);//선언 : AppConfig에 있는 환경설정 정보를 가지고 스프링이 스프링컨테이너에 넣고 관리한다.
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class); //찾기 : .getBean(찾을것,반환타입)

        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember((1L));
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new member"+member.getName());

    }
}
