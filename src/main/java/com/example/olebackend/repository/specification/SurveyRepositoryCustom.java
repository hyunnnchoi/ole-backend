package com.example.olebackend.repository.specification;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.web.dto.SurveyRequest;

import java.util.List;

public interface SurveyRepositoryCustom {
    public List<Lesson> strictFiltering(SurveyRequest.SurveyCondition condition) ;
    public List<Lesson> normalFiltering(SurveyRequest.SurveyCondition condition) ;
    public List<Lesson> lenientFiltering(SurveyRequest.SurveyCondition condition) ;
    public List<Lesson> findPastResults(Member member, List<Long> subcategoryIds) ;
}
