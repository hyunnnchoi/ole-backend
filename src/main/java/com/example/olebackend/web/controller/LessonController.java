package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.converter.LessonConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.jwt.service.JwtService;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.specification.LessonSpecification;
import com.example.olebackend.service.LessonService;
import com.example.olebackend.web.dto.LessonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.KEYWORD_NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;
    private final JwtService jwtService;

    @GetMapping("/{lessonId}")
    @Operation(summary = "교육 상세 조회 API")
    public ApiResponse<LessonResponse.getLessonDetailDTO> getLessonDetail(@PathVariable Long lessonId, HttpServletRequest request) {

        String accessToken = jwtService.extractAccessToken(request).orElse(null);

        Long memberId = null;

        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }

        LessonResponse.getLessonDetailDTO lessonDetail = lessonService.getLessonDetail(lessonId, memberId);

        return ApiResponse.onSuccess(lessonDetail);
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "카테고리별 교육 상세 조회 API")
    @Parameters({
            @Parameter(name = "keyword", description = "검색할 키워드입니다."),
            @Parameter(name = "page", description = "페이지 번호이며, 1페이지부터 시작입니다."),
    })
    public ApiResponse<LessonResponse.getLessonListDTO> getLessonListByCategory(@PathVariable Long categoryId,
                                                                                @RequestParam(required = false, value = "keyword") String keyword,
                                                                                @RequestParam(required = false, defaultValue = "1") Integer page) {
        Specification<Lesson> spec = (root, query, criteriaBuilder) -> null;

        // 키워드가 있으면 -> 키워드로 검색하는 spec 추가
        if (keyword != null) {
            spec = spec.and(LessonSpecification.findByKeyword(keyword));

        } else {
            spec = null;
        }

        Page<Lesson> lessonList = lessonService.getLessonList(categoryId, spec, page);
        return ApiResponse.onSuccess(LessonConverter.toLessonListDTO(lessonList));

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

    @GetMapping("/search")
    @Operation(summary = "검색 API")
    public ApiResponse<LessonResponse.getLessonListByCategoryAndSearchDTO> getLessonListBySearch(@RequestParam(required = false, value = "keyword") String keyword,
                                                                                                 @RequestParam(required = false, value = "fee") Boolean priceStatus,
                                                                                                 @RequestParam(required = false, value = "status") Boolean gatherStatus,
                                                                                                 @RequestParam(required = false, defaultValue = "1") Integer page) {
        Specification<Lesson> spec = (root, query, criteriaBuilder) -> null;

        if (priceStatus != null)
            spec = spec.and(LessonSpecification.findByPriceStatus(priceStatus));
        if (gatherStatus != null)
            spec = spec.and(LessonSpecification.findByGatherStatus(gatherStatus));
        if (keyword != null)
            spec = spec.and(LessonSpecification.findByKeyword(keyword));
        if (keyword == null && priceStatus == null && gatherStatus == null)
            throw new GeneralException(KEYWORD_NOT_FOUND);

        Page<Lesson> lessonList = lessonService.getLessonListBySearch(spec, page);
        return ApiResponse.onSuccess(LessonConverter.toLessonListByCategoryAndSearchDTO(lessonList));
    }

}

