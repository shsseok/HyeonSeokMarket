package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.exception.DuplicateUserException;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
    *회원가입
    **/
    @Transactional
    public Long join(Member member)
    {
        validateDuplicateMember(member);//중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
      if (!findMembers.isEmpty())
      {
          throw new DuplicateUserException("이미 존재하는 회원입니다");
      }

    }


    //회원 전체 조회

    public  List<Member> findMembers()
    {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }


}
