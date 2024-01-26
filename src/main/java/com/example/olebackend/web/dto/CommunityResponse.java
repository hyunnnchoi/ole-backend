package com.example.olebackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class CommunityResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getCommunityPreviewDTO {

        private Long id;
        private String title;
        private String body;
        private String category;
        private int views;
        private int commentCounts;

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
}
