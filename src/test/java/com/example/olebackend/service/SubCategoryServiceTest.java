package com.example.olebackend.service;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.SubCategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@SpringBootTest
@Transactional
class SubCategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository ;
    @Autowired
    private SubCategoryRepository subCategoryRepository ;


    @Test
    void 세부카테고리_목록조회() {

        Category category = Category.builder()
                .name("스마트폰")
                .build() ;

        SubCategory subCategory1 = SubCategory.builder()
                .name("기본설정")
                .category(category)
                .build() ;
        SubCategory subCategory2 = SubCategory.builder()
                .name("카메라")
                .category(category)
                .build() ;

        categoryRepository.save(category);
        subCategoryRepository.save(subCategory1);
        subCategoryRepository.save(subCategory2);

        List<SubCategory> subCategories = subCategoryRepository.findAllByCategory(category);

        Assertions.assertThat(subCategories.get(0)
                .getId().equals(subCategory1.getId())) ;
        Assertions.assertThat(subCategories.get(1)
                .getId().equals(subCategory1.getId())) ;
    } // 세부카테고리_목록조회
}