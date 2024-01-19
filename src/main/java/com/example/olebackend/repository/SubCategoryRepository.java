package com.example.olebackend.repository;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    /*
    카테고리별 서브 카테고리 조회
     */
    List<SubCategory> findAllByCategory(Category category) ;
}
