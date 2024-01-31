//package com.example.olebackend.config;
//
////import com.example.olebackend.jwt.filter.JwtAuthenticationProcessingFilter;
////import com.example.olebackend.jwt.service.JwtService;
////import com.example.olebackend.login.filter.CustomJsonUsernamePasswordAuthenticationFilter;
////import com.example.olebackend.login.handler.LoginFailureHandler;
////import com.example.olebackend.login.handler.LoginSuccessHandler;
////import com.example.olebackend.login.service.LoginService;
//import com.example.olebackend.repository.MemberRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//
//
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
////    private final LoginService loginService;
////    private final JwtService jwtService;
//    private final MemberRepository memberRepository;
//    private final ObjectMapper objectMapper;
//
//
//
//}
//
