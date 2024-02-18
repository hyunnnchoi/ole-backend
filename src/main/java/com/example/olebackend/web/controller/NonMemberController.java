package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.NonMemberConverter;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.service.NonMemberService;
import com.example.olebackend.web.dto.NonMemberRequest;
import com.example.olebackend.web.dto.NonMemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Validated
public class NonMemberController {
    private final NonMemberService nonMemberService;

    @PostMapping("/lesson/{lessonId}/guest")
        @Operation(summary = "교육 신청하기(비로그인) API")
        public ApiResponse<NonMemberResponse.ApplyResultDTO> apply(
            @Valid @RequestBody  NonMemberRequest.ApplyDTO request,
                @PathVariable(name = "lessonId") @Valid Long lessonId){

            NonMember nonMember = nonMemberService.applyLesson(request, lessonId);

            NonMemberResponse.ApplyResultDTO resultDto = NonMemberConverter.toApplyresultDTO(nonMember);
            return ApiResponse.onSuccess(resultDto);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping ("/guest/lessons")
    @Operation(summary = "비회원 신청 내역 조회 API")
    public ApiResponse<NonMemberResponse.getApplicationListResultDTO> getApplication(
            @PathVariable NonMemberRequest.getPhoneNumDTO request) {
        List<NonMember> nonMemberList = nonMemberService.getApplication(request);
        return ApiResponse.onSuccess(NonMemberConverter.toApplicationListDTO(nonMemberList));
    }

    @GetMapping ("/guest/lessons/completed")
    @Operation(summary = "비회원 수강 내역 조회 API")
    public ApiResponse<NonMemberResponse.getApplicationListResultDTO> getCompletedApplication(
            @PathVariable NonMemberRequest.getPhoneNumDTO request) {
        List<NonMember> nonMemberList = nonMemberService.getCompletedApplication(request);
        return ApiResponse.onSuccess(NonMemberConverter.toApplicationListDTO(nonMemberList));
    }

    @DeleteMapping("/guest/lessons/{lessonId}")
    @Operation(summary = "신청취소(비로그인)API")
    public ApiResponse<Object> cancelLesson(
            @RequestBody NonMemberRequest.getPhoneNumDTO request, @PathVariable(name = "lessonId") Long lessonId) {
        nonMemberService.cancelLesson(request,lessonId);
        return ApiResponse.onSuccess(null);
    }

}
