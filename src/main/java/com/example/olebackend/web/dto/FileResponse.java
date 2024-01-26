package com.example.olebackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FileResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getLessonImage {
        private Long id;
        private String path;
        private String name;
        private boolean represent;

    }

}
