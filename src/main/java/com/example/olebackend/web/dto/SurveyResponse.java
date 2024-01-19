package com.example.olebackend.web.dto;

import lombok.*;

public class SurveyResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class SubCategoryDto{
        Long sub_categoryId ;
        String name;
    } // SubCategoryDto
} // SurveyResponse
