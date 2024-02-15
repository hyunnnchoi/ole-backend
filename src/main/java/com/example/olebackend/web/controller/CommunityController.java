package com.example.olebackend.web.controller;

import com.example.olebackend.apiPayLoad.ApiResponse;
import com.example.olebackend.converter.CommunityConverter;
import com.example.olebackend.domain.Community;
import com.example.olebackend.domain.enums.CommunityCategory;
import com.example.olebackend.jwt.service.JwtService;
import com.example.olebackend.repository.specification.CommunitySpecification;
import com.example.olebackend.service.CommunityService;
import com.example.olebackend.web.dto.CommunityRequest;
import com.example.olebackend.web.dto.CommunityResponse;
import com.sun.net.httpserver.HttpServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;
    private final JwtService jwtService;


    @GetMapping
    @Operation(summary = "소통하러올래 목록 조회 API")
    @Parameters({
            @Parameter(name = "category", description = "소통하러올래 게시글 필터링 기준입니다. (궁금해요, 같이해요)"),
            @Parameter(name = "keyword", description = "검색 키워드 입니다."),
            @Parameter(name = "page", description = "페이지 번호이며, 1페이지부터 시작입니다.")
    })
    public ApiResponse<CommunityResponse.getCommunityListDTO> getCommunityList(@RequestParam(required = false) CommunityCategory category,
                                                                               @RequestParam(required = false) String keyword,
                                                                               @RequestParam(required = false, defaultValue = "1") Integer page) {
        // 카테고리가 있으면 카테고리 내에서 검색, 카테고리 없으면 전체에서 검색
        Specification<Community> spec = (root, query, criteriaBuilder) -> null;

        // 키워드가 있으면 검색 (카테고리 유무는 service에서 처리)
        if (keyword != null) {
            spec = spec.and(CommunitySpecification.findByKeyword(keyword));
            Page<Community> communityList = communityService.findCommunityListBySearch(category, spec, page);
            return ApiResponse.onSuccess(CommunityConverter.toCommunityListDTO(communityList));
        }
        // 키워드가 없으면 소통하러올래 게시글 전체 조회 (카테고리별 조회는 service에서 처리)
        else {
            Page<Community> communityList = communityService.getCommunityList(category, page);
            return ApiResponse.onSuccess(CommunityConverter.toCommunityListDTO(communityList));
        }
    }

    @GetMapping("/{communityId}")
    @Operation(summary = "소통하러올래 게시글 상세 조회 API")
    public ApiResponse<CommunityResponse.getCommunityDetailDTO> getCommunityDetail(@PathVariable Long communityId) {
        Optional<Community> community = communityService.getCommunity(communityId);
        return ApiResponse.onSuccess(CommunityConverter.toCommunityDetailDTO(community));
    }

    @PostMapping("/{communityId}/comments")
    @Operation(summary = "소통하러올래 댓글 작성 API")
    public ApiResponse<Object> addCommunityComments(@PathVariable Long communityId,
                                                    HttpServletRequest request,
                                                    @RequestBody @Valid CommunityRequest.toCommunityComment contentRequest) {
        String accessToken = jwtService.extractAccessToken(request).orElse(null);
        Long memberId = null;
        if (accessToken != null) {
            // AccessToken에서 memberId 추출
            memberId = jwtService.extractId(accessToken).orElse(null);
        }

        communityService.submitComment(communityId, memberId, contentRequest);
        return ApiResponse.onSuccess(null);
    }


}
