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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호이며, 1번이 1 페이지 입니다."),
    })
    public ApiResponse<LessonResponse.getLessonListByCategoryListlDTO> getLessonListByCategory(@PathVariable Long categoryId,
                                                                                               @RequestParam Integer page) {
        Page<Lesson> lessonList = lessonService.getLessonListByCategory(categoryId, page - 1);
        return ApiResponse.onSuccess(LessonConverter.toLessonListByCategoryDTO(lessonList));
    }

    @GetMapping
    @Operation(summary = "조건별 교육 조회 API")
    @Parameters({
            @Parameter(name = "orderBy", description = "교육을 조회할 정렬 기준입니다."),
    })
    public ApiResponse<LessonResponse.getLessonListOrderByCriteriaDTO> getLessonListByOrderCriteria(@RequestParam(required = false, defaultValue = "id", value = "orderBy") String orderCriteria) {

        List<Lesson> lessonList = lessonService.getLessonListByOrderCriteria(orderCriteria);

        return ApiResponse.onSuccess(LessonConverter.toLessonListOrderByCriteriaDTO(lessonList));
    }
}
