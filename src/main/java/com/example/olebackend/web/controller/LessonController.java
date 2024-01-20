package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.LessonConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.service.LessonService;
import com.example.olebackend.web.dto.LessonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/{lessonId}")
    @Operation(summary = "교육 상세 조회 API")
    public ApiResponse<LessonResponse.getLessonDetailDTO> getLessonDetail(@PathVariable Long lessonId) {
        Optional<Lesson> lesson = lessonService.getLessonDetail(lessonId);
        return ApiResponse.onSuccess(LessonConverter.toLessonDetailDTO(lesson));
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "카테고리별 교육 상세 조회 API")
    public ApiResponse<LessonResponse.getLessonListByCategoryListlDTO> getLessonListByCategory(@PathVariable Long categoryId,
                                                                                               @RequestParam Integer page) {
        Page<Lesson> lessonList = lessonService.getLessonListByCategory(categoryId, page-1);
        return ApiResponse.onSuccess(LessonConverter.toLessonListByCategoryDTO(lessonList));
    }
}
