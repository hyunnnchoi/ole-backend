package com.example.olebackend.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class MemberLoginRequest {
    private String email;
    private String password;
}
