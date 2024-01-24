package com.example.olebackend.web.dto;

import lombok.*;

import java.time.LocalDateTime;

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

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class SurveyResponseDto{

        Long lessonId ;
        String imgUrl ;
        String title; // 수업명
        LocalDateTime startDate; // 강의 시작일
        LocalDateTime endDate; // 강의 종료일
        LocalDateTime startTime; // 강의 시작 시간
        LocalDateTime endTime; // 강의 종료 시간
        String weekDay ; // 강의 진행 요일
        String place; // 수업 장소
        Integer price; // 가격
        Integer limitCount; // 신청 제한 인원
        Integer currentCount; // 현재 신청 인원
    } // SubCategoryDto



} // SurveyResponse
