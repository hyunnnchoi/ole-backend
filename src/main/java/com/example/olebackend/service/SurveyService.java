package com.example.olebackend.service;

import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final CategoryRepository categoryRepository ;
    private final SubCategoryRepository subCategoryRepository ;

    /*
    카테고리별 서브 카테고리 조회
     */
    @Transactional
    public List<SubCategory> getSubCategories(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId) ;
        return subCategoryRepository.findAllByCategory(category.get()) ;
    }


}
