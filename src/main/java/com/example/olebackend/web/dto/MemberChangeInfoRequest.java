package com.example.olebackend.web.dto;

import com.example.olebackend.domain.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberChangeInfoRequest {
    private String email;

    private String name;
    private String phoneNum;

    private Long birthYear;

    private String address;
    private Gender gender;

    private Boolean mailAgree;
    private Boolean smsAgree;

}

