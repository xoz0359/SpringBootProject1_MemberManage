package com.member_manager.service;

import com.member_manager.DTO.MemberSigninDTO;
import com.member_manager.DTO.MemberSignupDTO;
import com.member_manager.domain.Member;
import com.member_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, DataSource datasource) {
        this.memberRepository = memberRepository;
    }

    public int JoinMember(MemberSignupDTO memberSignupDTO) {
        Member member = new Member();
        member.setEmail(memberSignupDTO.getEmail());
        member.setPassword(memberSignupDTO.getPassword());
        member.setNickname(memberSignupDTO.getNickname());
        member.setName(memberSignupDTO.getName());
        member.setPhone(memberSignupDTO.getPhone());
        return memberRepository.addMember(member);
    }

    public Optional<Member> loginMember(MemberSigninDTO memberSigninDTO) {
        Member member = new Member();
        member.setEmail(memberSigninDTO.getEmail());
        member.setPassword(memberSigninDTO.getPassword());
        return Optional.ofNullable(memberRepository.checkMember(member));
    }
}
