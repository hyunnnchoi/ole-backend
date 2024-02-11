package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Category;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.SubCategory;
import com.example.olebackend.domain.mapping.Survey;
import com.example.olebackend.repository.CategoryRepository;
import com.example.olebackend.repository.MemberRepository;
import com.example.olebackend.repository.SubCategoryRepository;
import com.example.olebackend.repository.SurveyRepository;
import com.example.olebackend.web.dto.SurveyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

    private final CategoryRepository categoryRepository ;
    private final SubCategoryRepository subCategoryRepository ;
    private final SurveyRepository surveyRepository ;
    private final MemberRepository memberRepository ;

    /*
    카테고리별 서브 카테고리 조회
     */
    @Transactional
    public List<SubCategory> getSubCategories(Long categoryId){
        List<SubCategory> subCategories = subCategoryRepository.findAllByCategoryId(categoryId);
        if (subCategories.isEmpty()) {
            throw new GeneralException(SUBCATEGORY_NOT_FOUND) ;
        }
        return subCategories ;
    }

    /*
    이전 설문 내역 조사
     */
    @Transactional
    public List<Lesson> getPastResults(Long categoryId, Long memberId){

        Member member=memberRepository.findById(memberId)
                .orElseThrow(() ->new GeneralException(NEVER_SURVEYED));

        List<Long> subCategoryIds = subCategoryRepository.findIdsByCategoryId(categoryId);
        List<Lesson> lessons = surveyRepository.findPastResults(member, subCategoryIds);

        if(lessons.isEmpty())
            throw new GeneralException(NEVER_SURVEYED) ;
        return lessons ;
    } // getSurveyResults

    /*
    설문조사 결과
     */
    @Transactional
    public List<Lesson> getSurveyResults(SurveyRequest.SurveyCondition condition){

        List<Lesson> lessons = surveyRepository.strictFiltering(condition) ;
        log.info("strict Filtering");

        if (lessons.isEmpty()) {
            lessons = surveyRepository.normalFiltering(condition) ;
            log.info("normal Filtering");
        }
        if (lessons.isEmpty()) {
            lessons = surveyRepository.lenientFiltering(condition) ;
            log.info("lenient Filtering");
        }
        if (lessons.isEmpty()) {
            throw new GeneralException(LESSON_NOT_FOUND) ;
        }
        return lessons ;
    } // getSurveyResults

    /*
    설문 조사 결과 저장
     */
    @Transactional
    public void saveSurveyResults(Long memberId, List<Lesson> lessons){

        Member member=memberRepository.findById(memberId) // 토큰 검사 코드로 변경 필요
                .orElseThrow(() ->new GeneralException(MEMBER_NOT_FOUND));

        for(Lesson lesson : lessons){
            if(!surveyRepository.existsByMemberAndLesson(member, lesson))
                surveyRepository.save(Survey.createSurvey(member,lesson)) ;
        }
    } // postSurveyResults
}
