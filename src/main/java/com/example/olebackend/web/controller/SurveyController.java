package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.SurveyConverter;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.service.SurveyService;
import com.example.olebackend.web.dto.SurveyResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Operation(summary = "세부 카테고리 목록조회", description = "세부 카테고리 목록조회")
    @GetMapping("/sub_categories/{categoryId}")
    public ApiResponse<List<SurveyResponse.SubCategoryDto>> secondProblem(@PathVariable long categoryId){

        log.info("/sub_categories - "+ categoryId);

        List<SubCategory> subCategories = surveyService.getSubCategories(categoryId);
        List<SurveyResponse.SubCategoryDto> result = subCategories.stream()
                .map(s -> SurveyConverter.toSubCategoryDto(s))
                .collect(Collectors.toList());

        return ApiResponse.onSuccess(result) ;
    } // secondProblem
}
