package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.MemberConverter;
import com.example.olebackend.service.MemberService;
import com.example.olebackend.web.dto.MemberLoginRequest;
import com.example.olebackend.web.dto.MemberResponse;
import com.example.olebackend.web.dto.MemberSignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
//
//    @PostMapping("/member/signup")
//    public String signUp(@RequestBody MemberSignUpRequest memberSignUpDto) throws Exception{
//        memberService.signUp(memberSignUpDto);
//        return "signup success";
//    }
//
//    @GetMapping("/jwt-test")
//    public String jwtTest(){
//        return "jwtTest request success";
//    }

//    @PostMapping("/member/login")
//    public String login(@RequestBody MemberLoginRequest memberLoginDto) throws Exception{
//        memberService.login(memberLoginDto);
//        return "login success";
//    }
//    @GetMapping("/member/login")
//    String login() {
//        return "login";
//    }
}
