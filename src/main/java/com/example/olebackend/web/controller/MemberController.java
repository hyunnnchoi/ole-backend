package com.example.olebackend.web.controller;

import com.example.olebackend.service.MemberService;
import com.example.olebackend.web.dto.MemberSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public String signUp(@RequestBody MemberSignUpRequest memberSignUpDto) throws Exception{
        memberService.signUp(memberSignUpDto);
        return "signup success";
    }

    @GetMapping("/jwt-test")
    public String jwtTest(){
        return "jwtTest request success";
    }
}
