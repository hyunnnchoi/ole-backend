package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.web.dto.LikeResponse;
import com.example.olebackend.web.dto.SurveyResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class LikeConverter {

    /*
    설문조사
     */
    public static LikeResponse.LikeResponseDto toLikeResponse(Lesson lesson){

        return LikeResponse.LikeResponseDto.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .startDate(lesson.getLessonStartDate())
                .endDate(lesson.getLessonEndDate())
                .startTime(lesson.getLessonStartTime())
                .endTime(lesson.getLessonEndTime())
                .imgUrl(lesson.getImageUrl())
                .leftDays((int)ChronoUnit.DAYS.between(LocalDate.now(), lesson.getGatherEndDate()))
                .build();
    }
}
