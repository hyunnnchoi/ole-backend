package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.News;
import com.example.olebackend.domain.enums.NewsCategory;
import com.example.olebackend.repository.NewsRepository;
import com.example.olebackend.repository.specification.NewsSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;

    // 검색어 없을 때의 조회
    public Page<News> getNewsList(NewsCategory category, Integer page) {

        Page<News> newsList;

        if (category == null) {
            newsList = newsRepository.findAll(PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
        } else {
            newsList = newsRepository.findNewsByCategory(category, PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
        }
        // 전체 페이지 수 이상의 값을 입력했을 때
        if (page > newsList.getTotalPages()) {
            throw new GeneralException(PAGE_NOT_FOUND);
        }
        return newsList;
    }

    // 검색어 있을 때 조회
    public Page<News> getNewsListBySearch(NewsCategory category, Specification<News> spec, Integer page){

        // 카테고리가 없을 때 -> 전체에서 검색
        if (category == null) {
            return newsRepository.findAll(spec, PageRequest.of(page - 1, 10));
        }

        // 카테고리가 있을 때 -> 카테고리에 해당하는 게시글 중에서 검색
        else {
            spec = spec.and(NewsSpecification.findByCategory(category));
            return newsRepository.findAll(spec, PageRequest.of(page - 1, 10));
        }
    }

    @Transactional
    public Optional<News> getNewsDetail(Long newsId) {

        Optional<News> news = newsRepository.findById(newsId);

        // newsId에 해당하는 글이 없는 경우
        if (news.isEmpty()) {
            throw new GeneralException(NEWS_NOT_FOUND);
        }

        news.ifPresent(News::incrementViews);
        newsRepository.save(news.get());

        return news;
    }
}
