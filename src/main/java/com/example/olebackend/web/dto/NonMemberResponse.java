package com.example.olebackend.web.dto;

import lombok.*;

public class NonMemberResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApplyResultDTO{
        Long nonMemberId;
    }

}
