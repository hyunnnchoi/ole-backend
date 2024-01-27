package com.example.olebackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class CommunityResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCommunityPreviewDTO {

        Long id;
        String title;
        String body;
        String category;
        int views;
        int commentCounts;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCommunityListDTO {
        List<CommunityResponse.getCommunityPreviewDTO> communityList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCommunityDetailDTO {

        String title;
        String body;
        String category;
        int views;
        int commentCounts;
        String memberName;
        LocalDateTime createdAt;
        List<CommunityResponse.getCommunityCommentPreviewDTO> communityCommentList;


    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCommunityCommentPreviewDTO {

        Long id;
        String content;
        int likeCounts;
        String memberName;
        LocalDateTime createdAt;

    }
}
