package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.enums.ApplicationStatus;
import com.example.olebackend.domain.enums.Completed;
import com.example.olebackend.domain.mapping.LectureTeacher;
import com.example.olebackend.domain.mapping.MemberApply;
import com.example.olebackend.web.dto.LessonResponse;
import com.example.olebackend.web.dto.MemberApplyResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemberApplyConverter {
    public static MemberApply toMemberApply(Lesson lesson, Member member, ApplicationStatus applicationStatus){

        return MemberApply.builder()
                .lesson(lesson)
                .member(member)
                .attendanceStatus(Completed.NOT_COMPLETED)
                .applicationStatus(applicationStatus)
                .build();
    }

    public static MemberApplyResponse.applyResultDTO toApplyresultDTO(MemberApply memebrApply){
        return MemberApplyResponse.applyResultDTO.builder()
                .memberApplyId(memebrApply.getId())
                .build();
    }
    public static MemberApplyResponse.getApplicationResultDTO toApplicationDTO(Lesson lesson, MemberApply memberApply){

        List<LectureTeacher> teacherList = lesson.getLectureTeacherList();

        List<LessonResponse.getTeacherNameDTO> lessonTeacherList = teacherList.stream()
                .map(LessonConverter::toTeacherNameDTO).collect(Collectors.toList());

        return MemberApplyResponse.getApplicationResultDTO.builder()
                .lessonId(lesson.getId())
                .title(lesson.getTitle())
                .lessonStartDate(lesson.getLessonStartDate())
                .lessonEndDate(lesson.getLessonEndDate())
                .lessonStartTime(lesson.getLessonStartTime())
                .lessonEndTime(lesson.getLessonEndTime())
                .lessonTeacherList(lessonTeacherList)
                .place(lesson.getPlace())
                .categoryName(lesson.getSubCategory().getCategory().getName())
                .createdAt(memberApply.getCreatedAt())
                .applicationStatus(memberApply.getApplicationStatus())
                .imgUrl(lesson.getImageUrl())
                .build();
    }
    public static MemberApplyResponse.getApplicationListResultDTO toApplicationListDTO(List<MemberApply> memberApplyList) {

        List<MemberApplyResponse.getApplicationResultDTO> applicationList = memberApplyList.stream()
                .map(memberApply -> MemberApplyConverter.toApplicationDTO(memberApply.getLesson(),memberApply))
                .collect(Collectors.toList());

        return MemberApplyResponse.getApplicationListResultDTO.builder()
                .applicationList(applicationList)
                .build();
    }
}
