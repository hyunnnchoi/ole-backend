package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/health")
    public ApiResponse<Object> healthCheck(){
        return ApiResponse.onSuccess("I'm healthy") ;

    }
}
