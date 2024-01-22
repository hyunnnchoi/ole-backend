package com.example.olebackend.web.dto;

import lombok.Getter;

import javax.validation.constraints.*;

public class NonMemberRequest {
    @Getter
    public static class ApplyDTO{
        @NotBlank
        String name;
        @NotNull
        String email;
        @NotNull
        String phoneNum;
    }
    @Getter
    public static class getPhoneNumDTO{
        @NotNull
        String phoneNum;
    }
}
