package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.MemberApplyConverter;
import com.example.olebackend.domain.mapping.MemberApply;
import com.example.olebackend.jwt.service.JwtService;
import com.example.olebackend.service.MemberApplyService;
import com.example.olebackend.web.dto.MemberApplyResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApplyController {
    private final MemberApplyService memberApplyService;
    private final JwtService jwtService;

    @PostMapping("/lesson/{lessonId}/member")
    @Operation(summary = "교육 신청하기(로그인) API")
    public ApiResponse<MemberApplyResponse.applyResultDTO> apply(
            @PathVariable(name = "lessonId") @Valid Long lessonId,
            HttpServletRequest request){
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }

        MemberApply memberApply = memberApplyService.applyLesson(lessonId, memberId);

        MemberApplyResponse.applyResultDTO resultDto = MemberApplyConverter.toApplyresultDTO(memberApply);
        return ApiResponse.onSuccess(resultDto);
    }

    @DeleteMapping("/lesson/{lessonId}/member")
    @Operation(summary = "신청취소(로그인)API")
    public ApiResponse<Object> cancelLesson(
            @PathVariable(name = "lessonId") @Valid Long lessonId,
            HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }
        memberApplyService.cancelLesson(lessonId, memberId);
        return ApiResponse.onSuccess(null);
    }

    @PostMapping ("/member/lessons")
    @Operation(summary = "수업 신청 내역 조회 API")
    public ApiResponse<MemberApplyResponse.getApplicationListResultDTO> getLessons(
            HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }
        List<MemberApply> memeberApplyList = memberApplyService.getApplication(memberId);
        return ApiResponse.onSuccess(MemberApplyConverter.toApplicationListDTO(memeberApplyList));
    }

    @PostMapping ("/member/lessons/completed")
    @Operation(summary = "수업 수강 내역 조회 API")
    public ApiResponse<MemberApplyResponse.getApplicationListResultDTO> getCompletedLessons(
            HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }
        List<MemberApply> memeberApplyList = memberApplyService.getCompletedApplication(memberId);
        return ApiResponse.onSuccess(MemberApplyConverter.toApplicationListDTO(memeberApplyList));
    }
}
