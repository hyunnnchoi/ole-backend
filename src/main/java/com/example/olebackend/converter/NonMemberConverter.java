package com.example.olebackend.converter;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.domain.mapping.LectureTeacher;
import com.example.olebackend.web.dto.LessonResponse;
import com.example.olebackend.web.dto.NonMemberResponse;
import com.example.olebackend.web.dto.NonMemberRequest;

import java.util.List;
import java.util.stream.Collectors;

public class NonMemberConverter {
    public static NonMemberResponse.ApplyResultDTO toApplyresultDTO(NonMember nonMember){
        return NonMemberResponse.ApplyResultDTO.builder()
                .nonMemberId(nonMember.getId())
                .build();
    }

    public static NonMember toNonMember(NonMemberRequest.ApplyDTO request, Lesson lesson){

        return NonMember.builder()
                .lesson(lesson)
                .name(request.getName())
                .email(request.getEmail())
                .phoneNum(request.getPhoneNum())
                .build();
    }

    public static NonMemberResponse.getApplicationsResultDTO toApplicationsResultDTO(Lesson lesson){

        List<LectureTeacher> teacherList = lesson.getLectureTeacherList();

        List<LessonResponse.getTeacherNameDTO> lessonTeacherList = teacherList.stream()
                .map(LessonConverter::toTeacherNameDTO).collect(Collectors.toList());

        return NonMemberResponse.getApplicationsResultDTO.builder()
                .title(lesson.getTitle())
                .lessonStartDate(lesson.getLessonStartDate())
                .lessonEndDate(lesson.getLessonEndDate())
                .lessonStartTime(lesson.getLessonStartTime())
                .lessonEndTime(lesson.getLessonEndTime())
                .lessonTeacherList(lessonTeacherList)
                .place(lesson.getPlace())
                .build();
    }

    public static NonMember toCancelDTO(NonMemberRequest.cancelDTO request){

        return NonMember.builder()
                .phoneNum(request.getPhoneNum())
                .build();
    }
}
