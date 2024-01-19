package com.example.olebackend.converter;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.mapping.LectureTeacher;
import com.example.olebackend.web.dto.LessonResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LessonConverter {

    public static LessonResponse.getTeacherNameDTO toTeacherNameDTO(LectureTeacher teacher) {

        return LessonResponse.getTeacherNameDTO.builder()
                .name(teacher.getTeacher().getName())
                .build();
    }

    public static LessonResponse.getLessonDetailDTO toLessonDetailDTO(Optional<Lesson> lesson) {

        List<LectureTeacher> teacherList = lesson.get().getLectureTeacherList();

        List<LessonResponse.getTeacherNameDTO> lessonTeacherList = teacherList.stream()
                .map(LessonConverter::toTeacherNameDTO).collect(Collectors.toList());

        return LessonResponse.getLessonDetailDTO.builder()
                .title(lesson.get().getTitle())
                .description(lesson.get().getDescription())
                .lessonType(lesson.get().getLessonType().toString())
                .supplies(lesson.get().getSupplies())
                .price(lesson.get().getPrice())
                .refund(lesson.get().getRefund())
                .place(lesson.get().getPlace())
                .lessonStartDate(lesson.get().getLessonStartDate())
                .lessonEndDate(lesson.get().getLessonEndDate())
                .lectureWeekDay(lesson.get().getLectureWeekDay().toString())
                .lessonStartTime(lesson.get().getLessonStartTime())
                .lessonEndTime(lesson.get().getLessonEndTime())
                .approved(lesson.get().getApproved().toString())
                .gatherStartDate(lesson.get().getGatherStartDate())
                .gatherEndDate(lesson.get().getGatherEndDate())
                .limitCount(lesson.get().getLimitCount())
                .currentCount(lesson.get().getCurrentCount())
                .lessonTeacherList(lessonTeacherList)
                .build();
    }
}
