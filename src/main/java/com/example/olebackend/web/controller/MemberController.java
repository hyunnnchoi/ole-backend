package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.MemberConverter;
import com.example.olebackend.domain.Member;
import com.example.olebackend.jwt.service.JwtService;
import com.example.olebackend.login.filter.CustomJsonUsernamePasswordAuthenticationFilter;
import com.example.olebackend.service.MemberService;
import com.example.olebackend.web.dto.MemberLoginRequest;
import com.example.olebackend.web.dto.MemberResponse;
import com.example.olebackend.web.dto.MemberSignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService;
    private CustomJsonUsernamePasswordAuthenticationFilter customJsonUsernamePasswordAuthenticationFilter;

    // login은 JwtAuthenticationProcessingFilter에서 낚아채서 처리합니다.
    // {bcrypt}$2a$10$YDbw/rMsG6YteiS4kk7HrOqsBUkYPZ9fgfvfTkT5gywKG6vxl3AXO
    @PostMapping("/member/sign-up")
    public ApiResponse<MemberResponse.getJoinResultDTO> signUp(@RequestBody MemberSignUpRequest memberSignUpDto) throws Exception{
        Long memberId = memberService.signUp(memberSignUpDto);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(memberId));
    }
    @GetMapping("/member/detail")
    public ApiResponse<MemberResponse.getMemberDetailDTO> memberDetail(HttpServletRequest request){
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }
        return ApiResponse.onSuccess(MemberConverter.toMemberDetailDTO(memberService.getMemberDetail(memberId)));
    }

    @GetMapping("/jwt-test")
    public String jwtTest(){
        return "jwtTest request success";
    }
}
