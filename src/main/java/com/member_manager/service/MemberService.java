package com.member_manager.service;

import com.member_manager.DTO.MemberSigninDTO;
import com.member_manager.DTO.MemberSignupDTO;
import com.member_manager.domain.Member;
import com.member_manager.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public MemberService(MemberRepository memberRepository, DataSource datasource) {
        this.memberRepository = memberRepository;
    }

    public int JoinMember(MemberSignupDTO memberSignupDTO) {
        Member member = new Member();
        member.setEmail(memberSignupDTO.getEmail());
        String hashedPassword = passwordEncoder.encode(memberSignupDTO.getPassword());
        member.setPassword(hashedPassword);
        member.setNickname(memberSignupDTO.getNickname());
        member.setName(memberSignupDTO.getName());
        member.setPhone(memberSignupDTO.getPhone());
        return memberRepository.addMember(member);
    }

    public Optional<Member> loginMember(MemberSigninDTO memberSigninDTO) {
        Member member = new Member();
        member.setEmail(memberSigninDTO.getEmail());
        member.setPassword(memberSigninDTO.getPassword());
        Optional<Member> optionalMember =
                Optional.ofNullable(memberRepository.checkMember(member));

        if(optionalMember.isEmpty()){
            return Optional.empty();
        }
        return matchPassword(memberSigninDTO.getPassword(), optionalMember.get().getPassword())
                ? Optional.of(member) : Optional.empty();
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matchPassword(String inputPassword, String passwordData) {
        return passwordEncoder.matches(inputPassword, passwordData);
    }
}
