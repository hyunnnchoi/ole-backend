package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.NewsConverter;
import com.example.olebackend.domain.News;
import com.example.olebackend.domain.enums.NewsCategory;
import com.example.olebackend.repository.specification.NewsSpecification;
import com.example.olebackend.service.NewsService;
import com.example.olebackend.web.dto.NewsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    @Operation(summary = "올래생활뉴스 목록 조회 API")
    @Parameters({
            @Parameter(name = "category", description = "올래생활뉴스 게시글 필터링 기준입니다. (공지사항, 건강정보, 생활정보, 취업정보)"),
            @Parameter(name = "keyword", description = "검색 키워드 입니다."),
            @Parameter(name = "page", description = "페이지 번호이며, 1페이지부터 시작입니다."),
    })
    public ApiResponse<NewsResponse.getNewsListDTO> getNewsList(@RequestParam(required = false) NewsCategory category,
                                                                @RequestParam(required = false) String keyword,
                                                                @RequestParam(required = false, defaultValue = "1") Integer page) {

        // 카테고리가 있으면 카테고리 내에서 검색, 카테고리 없으면 전체에서 검색
        Specification<News> spec = (root, query, criteriaBuilder) -> null;

        // 키워드가 있으면 검색 (카테고리 유무는 service에서 처리)
        if(keyword != null) {
            spec = spec.and(NewsSpecification.findByKeyword(keyword));
            Page<News> newsList = newsService.getNewsListBySearch(category, spec, page);
            return ApiResponse.onSuccess(NewsConverter.toNewsListDTO(newsList));
        }
        // 키워드가 없으면 소통하러올래 게시글 전체 조회 (카테고리별 조회는 service에서 처리)
        else{
            Page<News> newsList = newsService.getNewsList(category, page);
            return ApiResponse.onSuccess(NewsConverter.toNewsListDTO(newsList));
        }
    }

    @GetMapping("/{newsId}")
    @Operation(summary = "올래생활뉴스 글 상세 조회 API")
    public ApiResponse<NewsResponse.getNewsDetailDTO> getNewsDetail(@PathVariable Long newsId) {
        Optional<News> news = newsService.getNewsDetail(newsId);
        return ApiResponse.onSuccess(NewsConverter.toNewsDetailDTO(news));
    }
}
