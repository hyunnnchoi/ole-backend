package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.LessonConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.service.LessonService;
import com.example.olebackend.web.dto.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/{lessonId}")
    public ApiResponse<LessonResponse.getLessonDetailDTO> getLessonDetail(@PathVariable Long lessonId) {
        Optional<Lesson> lesson = lessonService.getLessonDetail(lessonId);
        return ApiResponse.onSuccess(LessonConverter.toLessonDetailDTO(lesson));
    }
}
