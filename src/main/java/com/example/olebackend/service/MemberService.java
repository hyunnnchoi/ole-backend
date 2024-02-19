package com.example.olebackend.service;

import com.example.olebackend.converter.MemberConverter;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.enums.Role;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.MemberApplyRepository;
import com.example.olebackend.repository.MemberRepository;
//import com.example.olebackend.web.dto.MemberLoginRequest;
import com.example.olebackend.web.dto.MemberChangeInfoRequest;
import com.example.olebackend.web.dto.MemberChangePasswordRequest;
import com.example.olebackend.web.dto.MemberSignUpRequest;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final LessonRepository lessonRepository;
    private final MemberApplyRepository memberApplyRepository;

    public Long signUp(MemberSignUpRequest memberSignUpDto) throws Exception{

        if(memberRepository.findByEmail(memberSignUpDto.getEmail()).isPresent()){
            throw new Exception("이미 가입된 이메일입니다.");
        }

//        if(memberRepository.findByPhoneNum(memberSignUpDto.getPhoneNum()).isPresent()){
//            throw new Exception("이미 가입된 전화번호입니다.");
//        }
//
        Member member = Member.builder()
                .email(memberSignUpDto.getEmail())
                .password(memberSignUpDto.getPassword())
                .name(memberSignUpDto.getName())
                .phoneNum(memberSignUpDto.getPhoneNum())
                .birthYear(memberSignUpDto.getBirthYear())
                .address(memberSignUpDto.getAddress())
                .gender(memberSignUpDto.getGender())
                .mailAgree(memberSignUpDto.getMailAgree())
                .smsAgree(memberSignUpDto.getSmsAgree())
                .role(Role.USER)
                .build();

        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
        return member.getId();
    }
    public Member getMemberDetail(Long memberId) {

        Member member = memberRepository.findById(memberId).orElseThrow();
        return member;
    }

    public void updateMemberDetail(Long memberId, MemberChangeInfoRequest memberChangeInfoRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.setEmail(memberChangeInfoRequest.getEmail());
        member.setName(memberChangeInfoRequest.getName());
        member.setPhoneNum(memberChangeInfoRequest.getPhoneNum());
        member.setBirthYear(memberChangeInfoRequest.getBirthYear());
        member.setAddress(memberChangeInfoRequest.getAddress());
        member.setGender(memberChangeInfoRequest.getGender());
        member.setMailAgree(memberChangeInfoRequest.getMailAgree());
        member.setSmsAgree(memberChangeInfoRequest.getSmsAgree());
        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }
    public void updatePassword(Long memberId, MemberChangePasswordRequest memberChangePasswordRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.updatePassword(memberChangePasswordRequest.getPassword(), passwordEncoder);
        memberRepository.save(member);
    }

}
