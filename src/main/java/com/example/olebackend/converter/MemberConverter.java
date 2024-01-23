package com.example.olebackend.converter;

import com.example.olebackend.domain.*;
import com.example.olebackend.domain.enums.Attended;
import com.example.olebackend.domain.mapping.MemberApply;
import com.example.olebackend.web.dto.MemberResponse;

public class MemberConverter {
    public static MemberResponse.JoinResultDTO toJoinResultDTO(Long memberId){
        return MemberResponse.JoinResultDTO.builder()
                .memberId(memberId)
                .build();
    }

    public static MemberApply toMemberApply(Lesson lesson, Member member){

        return MemberApply.builder()
                .lesson(lesson)
                .member(member)
                .attendanceStatus(Attended.ATTENDING)
                .build();
    }

    public static MemberResponse.applyResultDTO toApplyresultDTO(MemberApply memebrApply){
        return MemberResponse.applyResultDTO.builder()
                .memberApplyId(memebrApply.getId())
                .build();
    }
}
