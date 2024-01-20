package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CategoryRepository categoryRepository;

    public Optional<Lesson> getLessonDetail(Long lessonId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        if (!lessonRepository.existsById(lessonId)) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }
        return lesson;
    }

    public Page<Lesson> getLessonListByCategory(Long categoryId, Integer page) {

        Page<Lesson> lessonList = lessonRepository.findLessonsByCategoryId(categoryId, PageRequest.of(page, 10));

        // 카테고리 자체가 없을 때
        if (!categoryRepository.existsById(categoryId)) {
            throw new GeneralException(CATEGORY_NOT_FOUND);
        }

        // 해당 카테고리에 존재하는 교육이 없을 때
        if (lessonList.getTotalPages() == 0) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }

        // 전체 페이지 수 이상의 값을 입력했을 때
        if (page > lessonList.getTotalPages()) {
            throw new GeneralException(PAGE_NOT_FOUND);
        }

        // 1 미만의 페이지를 입력했을 때
        if (page < 1) {
            throw new GeneralException(PAGE_INVALID);
        }

        return lessonList;
    }

    public List<Lesson> getLessonListByOrderCriteria(String orderCriteria) {

        // 존재하지 않는 정렬 조건일 때 (=정렬 조건이 Lesson의 필드명과 일치하지 않을 때)
        try {
            Lesson.class.getDeclaredField(orderCriteria);
        } catch (NoSuchFieldException e) {
            throw new GeneralException(ORDER_CRITERIA_INVALID);
        }

        List<Lesson> lessonList = lessonRepository.findAll(Sort.by(Sort.Direction.DESC, orderCriteria));

        return lessonList;
    }
}
