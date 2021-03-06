package spring.core.member;

// impl: 구현체

public class MemberServiceImpl implements MemberService {
    // MemberServiceImpl 자체도 구현체인데, 아래에서 MemberMemberRepository 라는 또 다른 구현체를 할당 받고 있다. (의존 문제)
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // AppConfig가 생겼으니 지워준다.

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }// 추상화에만 의존하게 된다. => memoryMemberRepository에 대한 코드가 전혀 없기 때문! 구체적 코드(구현코드)를 외부에서 주입시킨다(생성자 주입)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
