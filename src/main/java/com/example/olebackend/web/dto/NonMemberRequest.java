package com.example.olebackend.web.dto;

import lombok.Getter;

import javax.validation.constraints.*;

public class NonMemberRequest {
    @Getter
    public static class ApplyDTO{
        @NotBlank(message = "이름은 공백일 수 없습니다!")
        String name;

        String email;
        @NotBlank(message = "전화번호는 공백일 수 없습니다!")
        String phoneNum;
    }
}
