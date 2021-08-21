package hello.core.member;

public class MemberServiceImpl implements  MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }//생성자를 통해 뭐가 들어갈지 넣어 줄 것 임

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
