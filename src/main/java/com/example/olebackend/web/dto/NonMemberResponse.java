package com.example.olebackend.web.dto;

import com.example.olebackend.domain.NonMember;
import com.example.olebackend.domain.enums.ApplicationStatus;
import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;
import java.util.List;

public class NonMemberResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApplyResultDTO{
        Long nonMemberId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getApplicationResultDTO{

        String title; //강의 제목
        LocalDateTime lessonStartDate; // 강의 시작일
        LocalDateTime lessonEndDate; // 강의 종료일
        LocalDateTime lessonStartTime; // 강의 시작 시간
        LocalDateTime lessonEndTime; // 강의 종료 시간
        List<LessonResponse.getTeacherNameDTO> lessonTeacherList; // 강사
        String place; //강의 장소
        Long categoryId; //신청한 강의 카테고리
        LocalDateTime createdAt; //신청 날짜
        ApplicationStatus applicationStatus; //신청 상태
        String imgUrl; //이미지 url

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getApplicationListResultDTO {
        List<NonMemberResponse.getApplicationResultDTO> applicationList;
    }

}
