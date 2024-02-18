package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.SurveyConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.jwt.service.JwtService;
import com.example.olebackend.service.SurveyService;
import com.example.olebackend.web.dto.SurveyRequest;
import com.example.olebackend.web.dto.SurveyResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SurveyController {

    private final SurveyService surveyService;
    private final JwtService jwtService;



    @Operation(summary = "세부 카테고리 목록조회", description = "세부 카테고리 목록조회")
    @GetMapping("/sub_categories/{categoryId}")
    public ApiResponse<List<SurveyResponse.SubCategoryDto>> secondProblem(
            @PathVariable long categoryId){

        log.info("/sub_categories - "+ categoryId);

        List<SubCategory> subCategories = surveyService.getSubCategories(categoryId);
        List<SurveyResponse.SubCategoryDto> result = subCategories.stream()
                .map(s -> SurveyConverter.toSubCategoryDto(s))
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result) ;
    } // secondProblem
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "설문조사-이전 참여내역 조회", description = "설문조사 - 이전 참여내역 조회")
    @GetMapping("/lessons/{categoryId}/surveys")
    public ApiResponse<List<SurveyResponse.SurveyResponseDto>> pastResults(
            @PathVariable(name = "categoryId") Long categoryId,
            HttpServletRequest request){
        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }

        log.info("/lessons/survey(get)");

        List<Lesson> surveyResults = surveyService.getPastResults(categoryId, memberId);
        List<SurveyResponse.SurveyResponseDto> result = surveyResults.stream()
                .map(s -> SurveyConverter.toSurveyResponseDto(s))
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result) ;
    } // pastResults


    @Operation(summary = "설문조사 제출- 강의 추천하기", description = "설문조사 - 강의 추천하기")
    @PostMapping("/lessons/survey")
    public ApiResponse<List<SurveyResponse.SurveyResponseDto>> surveyResults(
            @RequestBody SurveyRequest.SurveyCondition condition,
            HttpServletRequest request){

        log.info("/lessons/survey(post)");

        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }
        List<Lesson> surveyResults = surveyService.getSurveyResults(condition);
        if(memberId != null){
            surveyService.saveSurveyResults(memberId ,surveyResults) ;
        }

        List<SurveyResponse.SurveyResponseDto> result = surveyResults.stream()
                .map(s -> SurveyConverter.toSurveyResponseDto(s))
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result) ;
    } // surveyResults

}
