package com.example.olebackend.repository;

import com.example.olebackend.domain.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long>, JpaSpecificationExecutor<Lesson> {
    Page<Lesson> findBySubCategoryCategoryId(Long categoryId, PageRequest pageRequest);

    List<Lesson> findBySubCategoryCategoryId(Long categoryId);

    @Query("SELECT l FROM Lesson l ORDER BY (l.limitCount / l.currentCount)")
    Page<Lesson> orderByLimitAndCurrent(List<Lesson> lessonList, PageRequest pageRequest);


}
