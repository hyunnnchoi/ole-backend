package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/health")
    public String healthCheck(){
        return "I'm healthy";

    }
}
