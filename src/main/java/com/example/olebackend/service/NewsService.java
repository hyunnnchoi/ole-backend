package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.News;
import com.example.olebackend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.PAGE_NOT_FOUND;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;

    public Page<News> getNewsList(Integer page) {
        Page<News> newsList = newsRepository.findAll(PageRequest.of(page - 1, 10));

        // 전체 페이지 수 이상의 값을 입력했을 때
        if (page > newsList.getTotalPages()) {
            throw new GeneralException(PAGE_NOT_FOUND);
        }
        return newsList;
    }
}
