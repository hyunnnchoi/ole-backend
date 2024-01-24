package com.example.olebackend.web.dto;

import lombok.*;

public class SurveyRequest {

    @Data
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurveyCondition{
        Long[] sub_categoryIds ;
        Integer[] classType ;
        int teacher_gender ;
        Integer[] teacher_age ;
        Integer[] choices ;
        int age ;
        int gender ;
        String address ;
    } // SubCategoryDto
}
