package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.converter.LessonConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.LikeRepository;
import com.example.olebackend.repository.MemberApplyRepository;
import com.example.olebackend.web.dto.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CategoryRepository categoryRepository;
    private final LikeRepository likeRepository;
    private final MemberApplyRepository memberApplyRepository;

    @Transactional
    public LessonResponse.getLessonDetailDTO getLessonDetail(Long lessonId, Long memberId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);

        Boolean likeStatus = false;
        Boolean applyStatus = false;

        // 로그인이 된 상태라면
        if (memberId != null) {
            likeStatus = likeRepository.existsByLesson_IdAndMember_Id(lessonId, memberId);
            applyStatus = memberApplyRepository.existsByLessonIdAndMemberId(lessonId, memberId);
        }

        // 조회 수 증가 로직
        lesson.ifPresent(Lesson::incrementViews);
        lessonRepository.save(lesson.get());

        // 해당하는 교육이 없으면
        if (!lessonRepository.existsById(lessonId)) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }
        return LessonConverter.toLessonDetailDTO(lesson, likeStatus, applyStatus);
    }

    public Page<Lesson> getLessonList(Long categoryId, Specification<Lesson> spec, String orderCriteria, Integer page) {

        Sort sort = buildSort(orderCriteria);

        PageRequest pageRequest = PageRequest.of(page - 1, 10, sort);

        Page<Lesson> lessonList;

        if (orderCriteria.equals("join")) {
            lessonList = lessonRepository.orderByLimitAndCurrent(lessonRepository.findAll(spec), PageRequest.of(page - 1, 10));
        } else {
            lessonList = lessonRepository.findAll(spec, pageRequest);
        }

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

        return lessonList;
    }

    private Sort buildSort(String orderCriteria) {
        if ("gatherEndDate".equals(orderCriteria)) {
            return Sort.by("gatherEndDate");
        } else if ("createdAt".equals(orderCriteria)) {
            return Sort.by("createdAt").descending();
        } else {
            return Sort.by("createdAt").descending();
        }
    }

    public List<Lesson> getLessonListByOrderCriteria(String orderCriteria) {

        Class<?> currentClass = Lesson.class;
        while (currentClass != null) {
            try {
                currentClass.getDeclaredField(orderCriteria);
                break;
            } catch (NoSuchFieldException ignored) {
                currentClass = currentClass.getSuperclass();
            }
        }

        if (currentClass == null) {
            throw new GeneralException(ORDER_CRITERIA_INVALID);
        }

        List<Lesson> lessonList = lessonRepository.findAll(Sort.by(Sort.Direction.DESC, orderCriteria));

        return lessonList;
    }

    public Page<Lesson> getLessonListBySearch(Specification<Lesson> spec, Integer page) {

        Page<Lesson> lessonList = lessonRepository.findAll(spec, PageRequest.of(page - 1, 10));
        return lessonList;
    }
}
