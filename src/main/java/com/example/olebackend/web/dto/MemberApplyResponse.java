package com.example.olebackend.web.dto;

import com.example.olebackend.domain.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MemberApplyResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class applyResultDTO{
        Long memberApplyId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getApplicationResultDTO{

        Long lessonId; //강의 아이디
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
        String imgUrl ; //이미지 url

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getApplicationListResultDTO {
        List<MemberApplyResponse.getApplicationResultDTO> applicationList;
    }
}
