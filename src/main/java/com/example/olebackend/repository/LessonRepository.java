package com.example.olebackend.repository;

import com.example.olebackend.domain.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends JpaRepository<Lesson, Long>, JpaSpecificationExecutor<Lesson> {

    @Query("SELECT l FROM Lesson l WHERE l.subCategory.category.id = :categoryId")
    Page<Lesson> findLessonsByCategoryId(@Param("categoryId") Long categoryId, PageRequest pageRequest);
}
