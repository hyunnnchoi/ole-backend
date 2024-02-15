package com.example.olebackend.converter;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.domain.enums.ApplicationStatus;
import com.example.olebackend.domain.enums.Completed;
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

    public static NonMember toNonMember(NonMemberRequest.ApplyDTO request, Lesson lesson,ApplicationStatus applicationStatus){

        return NonMember.builder()
                .lesson(lesson)
                .name(request.getName())
                .email(request.getEmail())
                .phoneNum(request.getPhoneNum())
                .attendanceStatus(Completed.NOT_COMPLETED)
                .applicationStatus(applicationStatus)
                .build();
    }

    public static NonMemberResponse.getApplicationResultDTO toApplicationDTO(Lesson lesson, NonMember nonMember){

        List<LectureTeacher> teacherList = lesson.getLectureTeacherList();

        List<LessonResponse.getTeacherNameDTO> lessonTeacherList = teacherList.stream()
                .map(LessonConverter::toTeacherNameDTO).collect(Collectors.toList());

        return NonMemberResponse.getApplicationResultDTO.builder()
                .title(lesson.getTitle())
                .lessonStartDate(lesson.getLessonStartDate())
                .lessonEndDate(lesson.getLessonEndDate())
                .lessonStartTime(lesson.getLessonStartTime())
                .lessonEndTime(lesson.getLessonEndTime())
                .lessonTeacherList(lessonTeacherList)
                .place(lesson.getPlace())
                .categoryId(lesson.getSubCategory().getCategory().getId())
                .createdAt(nonMember.getCreatedAt())
                .applicationStatus(nonMember.getApplicationStatus())
                .build();
    }
    public static NonMemberResponse.getApplicationListResultDTO toApplicationListDTO(List<NonMember> nonMembers) {

        List<NonMemberResponse.getApplicationResultDTO> applicationList = nonMembers.stream()
                .map(nonMember -> NonMemberConverter.toApplicationDTO(nonMember.getLesson(),nonMember))
                .collect(Collectors.toList());

        return NonMemberResponse.getApplicationListResultDTO.builder()
                .applicationList(applicationList)
                .build();
    }
}
