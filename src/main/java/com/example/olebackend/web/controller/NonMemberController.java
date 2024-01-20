package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.NonMemberConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.service.NonMemberService;
import com.example.olebackend.web.dto.NonMemberRequest;
import com.example.olebackend.web.dto.NonMemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class NonMemberController {
    private final NonMemberService nonMemberService;

    @PostMapping("/lesson/{lessonId}/guest")
        @Operation(summary = "교육 신청하기(비로그인) API")
        public ApiResponse<NonMemberResponse.ApplyResultDTO> apply(
                @RequestBody NonMemberRequest.ApplyDTO request,
                @PathVariable Long lessonId){

            NonMember nonMember = nonMemberService.applyLesson(request, lessonId);

            NonMemberResponse.ApplyResultDTO resultDto = NonMemberConverter.toApplyresultDTO(nonMember);
            return ApiResponse.onSuccess(resultDto);
    }

    @GetMapping("/guest/lessons")
    @Operation(summary = "비회원 신청 내역 조회 API")
    public ApiResponse<NonMemberResponse.getApplicationsResultDTO> getLessonDetail(@RequestParam String phoneNum) {
        Lesson lesson = nonMemberService.getApplications(phoneNum);
        return ApiResponse.onSuccess(NonMemberConverter.toApplicationsResultDTO(lesson));
    }

    @DeleteMapping("/guest/lessons")
    @Operation(summary = "신청취소(비로그인)API")
    public ApiResponse<Object> cancelLesson(
            @RequestBody NonMemberRequest.cancelDTO request, @RequestParam Long lessonId) {
        nonMemberService.cancelLesson(request,lessonId);
        return ApiResponse.onSuccess(null);
    }

}
