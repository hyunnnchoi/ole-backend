package com.example.olebackend.converter;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.web.dto.NonMemberResponse;
import com.example.olebackend.web.dto.NonMemberRequest;

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
                .email(request.getPhoneNum())
                .phoneNum(request.getPhoneNum())
                .build();
    }
}
