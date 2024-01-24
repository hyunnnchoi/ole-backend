package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.web.dto.SurveyResponse;

import java.util.List;
import java.util.Optional;

public class SurveyConverter {

    /*
    설문조사 2번문항 - 세부 카테고리 불러오기
     */
    public static SurveyResponse.SubCategoryDto toSubCategoryDto(SubCategory subCategory){
        return SurveyResponse.SubCategoryDto.builder()
                .sub_categoryId(subCategory.getId())
                .name(subCategory.getName())
                .build();
    } // toSubCategoryDto

    /*
    설문조사
     */
    public static SurveyResponse.SurveyResponseDto toSurveyResponseDto(Lesson lesson){

        // '대표 이미지여부' 속성이 true인 파일 필터링
        Optional<File> representativeFile = lesson.getFileList()
                .stream()
                .filter(e -> e.isRepresent())
                .findAny() ;

        // 대표 이미지가 존재하는 경우에만 imgUrl을 설정, 아니면 null
        String imgUrl =  representativeFile.map(File::getPath).orElse(null);

        return SurveyResponse.SurveyResponseDto.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .place(lesson.getPlace())
                .price(lesson.getPrice())
                .startDate(lesson.getLessonStartDate())
                .endDate(lesson.getLessonEndDate())
                .startTime(lesson.getLessonStartTime())
                .endTime(lesson.getLessonEndTime())
                .weekDay(lesson.getLectureWeekDay().toString())
                .imgUrl(imgUrl)
                .currentCount(lesson.getCurrentCount())
                .limitCount(lesson.getLimitCount())
                .build();
    }


}
