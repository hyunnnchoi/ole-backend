package com.example.olebackend.converter;

import com.example.olebackend.domain.File;
import com.example.olebackend.domain.News;
import com.example.olebackend.web.dto.NewsResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class NewsConverter {

    public static NewsResponse.getNewsPreviewDTO toNewsPreviewDTO(News news) {

        List<File> fileList = news.getFileList();

        File file = fileList.stream()
                .filter(File::isRepresent)
                .findFirst()
                .orElse(null);

        return NewsResponse.getNewsPreviewDTO.builder()
                .id(news.getId())
                .title(news.getTitle())
                .content(news.getContent())
                .category(news.getCategory().toString())
                .author(news.getAuthor())
                .filePath(file.getPath())
                .build();
    }

    public static NewsResponse.getNewsListDTO toNewsListDTO(Page<News> newsList) {
        List<NewsResponse.getNewsPreviewDTO> newsPreviewDTOList = newsList.stream()
                .map(NewsConverter::toNewsPreviewDTO).collect(Collectors.toList());

        return NewsResponse.getNewsListDTO.builder()
                .newsList(newsPreviewDTOList)
                .isLast(newsList.isLast())
                .isFirst(newsList.isFirst())
                .totalPage(newsList.getTotalPages())
                .totalElements(newsList.getTotalElements())
                .listSize(newsPreviewDTOList.size())
                .build();
    }
}
