package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.NonMemberConverter;
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

}
