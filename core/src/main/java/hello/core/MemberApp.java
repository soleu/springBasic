package hello.core;

import hello.core.member.Member;
import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp { //순수 자바로 테스트 하는 방법
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        // MemberService memberService=new MemberServiceImpl();
        MemberService memberService= appConfig.memberService();//이런식으로 appConfig를 이용하여 Service 메서드를 사용한다
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember((1L));
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new member"+member.getName());

    }
}
