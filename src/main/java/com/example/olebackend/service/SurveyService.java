package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.SubCategoryRepository;
import com.example.olebackend.repository.SurveyRepository;
import com.example.olebackend.web.dto.SurveyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final CategoryRepository categoryRepository ;
    private final SubCategoryRepository subCategoryRepository ;
    private final SurveyRepository surveyRepository ;

    /*
    카테고리별 서브 카테고리 조회
     */
    @Transactional
    public List<SubCategory> getSubCategories(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId) ;
        List<SubCategory> subCategories = subCategoryRepository.findAllByCategory(category.get());
        if (subCategories.isEmpty()) {
            throw new GeneralException(SUBCATEGORY_NOT_FOUND) ;
        }
        return subCategories ;
    }

    /*
    맞춤 교육 추천
     */
    @Transactional
    public List<Lesson> getSurveyResults(SurveyRequest.SurveyCondition condition){

        List<Lesson> lessons = surveyRepository.search(condition) ;
        if (lessons.isEmpty()) {
            throw new GeneralException(LESSON_NOT_FOUND) ;
        }
        return lessons ;
    } // getSurveyResults


}
