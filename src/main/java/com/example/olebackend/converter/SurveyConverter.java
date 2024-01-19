package com.example.olebackend.converter;

import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.web.dto.SurveyResponse;

import java.util.List;

public class SurveyConverter {

    /*
    설문조사 2번문항 - 세부 카테고리 불러오기
     */
    public static SurveyResponse.SubCategoryDto toSubCategoryDto(SubCategory subCategory){
        return SurveyResponse.SubCategoryDto.builder()
                .sub_categoryId(subCategory.getId())
                .name(subCategory.getName())
                .build();
    } // toSubCategoryDto
}
