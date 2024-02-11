package com.example.olebackend.repository;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    /*
    카테고리별 서브 카테고리 조회
     */
    @Query("SELECT s FROM SubCategory s WHERE s.category.id = :categoryId")
    List<SubCategory> findAllByCategoryId(@Param(value="categoryId") Long categoryId) ;

    @Query("SELECT s.id FROM SubCategory s WHERE s.category.id = ?1")
    List<Long> findIdsByCategoryId(Long categoryId) ;
}
