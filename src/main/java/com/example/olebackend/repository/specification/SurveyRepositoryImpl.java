package com.example.olebackend.repository.specification;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.enums.Type;
import com.example.olebackend.domain.enums.Week;
import com.example.olebackend.domain.mapping.QSurvey;
import com.example.olebackend.web.dto.SurveyRequest;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.olebackend.domain.QLesson.lesson;
import static com.example.olebackend.domain.mapping.QSurvey.*;
import static com.querydsl.core.util.ArrayUtils.isEmpty;

public class SurveyRepositoryImpl implements SurveyRepositoryCustom{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public SurveyRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Lesson> findPastResults(Member member, List<Long> subcategoryIds){
        return queryFactory
                .select(lesson)
                .from(survey)
                .where(survey.member.id.eq(member.getId())
                        .and(survey.lesson.subCategory.id.in(subcategoryIds)))
                .fetch() ;
    } // strictFiltering


    @Override
    public List<Lesson> strictFiltering(SurveyRequest.SurveyCondition condition){
        return queryFactory
                .selectFrom(lesson)
                .where(subcategoryEq(condition.getSub_categoryIds()),
                        lessonTypeEq(condition.getClassType()),
                        teacherGenderEq(condition.getTeacher_gender()),
                        teacherAgeEq(condition.getTeacher_age()),
                        weekDayEq(condition.getChoices()),
                        classTimeEq(condition.getChoices()))
                .fetch() ;
    } // strictFiltering

    @Override
    public List<Lesson> normalFiltering(SurveyRequest.SurveyCondition condition){
        return queryFactory
                .selectFrom(lesson)
                .where(subcategoryEq(condition.getSub_categoryIds()),
                        lessonTypeEq(condition.getClassType()),
                        weekDayEq(condition.getChoices()),
                        classTimeEq(condition.getChoices())
                                )
                .fetch() ;
    } // normalFiltering

    @Override
    public List<Lesson> lenientFiltering(SurveyRequest.SurveyCondition condition){
        return queryFactory
                .select(lesson)
                .from(lesson)
                .where(subcategoryEq(condition.getSub_categoryIds()),
                        lessonTypeEq(condition.getClassType()))
                .fetch() ;
    } // lenientFiltering


    /*
    세부 카테고리
    */
    private BooleanExpression subcategoryEq(Long[] subCategoryIds) {
        if (isEmpty(subCategoryIds)) {
            return lesson.gatherStatus.eq(true);
        } else {
            return lesson.subCategory.id.in(subCategoryIds).and(lesson.gatherStatus.eq(true));
        }
    }

    /*
    교육 방식
     */
    private BooleanExpression lessonTypeEq(Integer[] classTypes) {
        if (isEmpty(classTypes)) {
            return null;
        } else {
            Type[] lessonTypes = Arrays.stream(classTypes)
                    .map(type -> type == 0 ? Type.OFFLINE : Type.ONLINE)
                    .toArray(Type[]::new);

            return lesson.lessonType.in(lessonTypes);
        }
    }


    /*
    선생님 성별
     */
    private BooleanExpression teacherGenderEq(int teacher_gender) {

        if (teacher_gender == 1) {
            // 성별이 남자(1)
            return lesson.lectureTeacherList.any().teacher.gender.eq("MAN");
        } else if(teacher_gender == 2){
            // 성별이 여자(2)일 때
            return lesson.lectureTeacherList.any().teacher.gender.eq("WOMAN");
        }else{ 
            // 상관없음(3)일 때
            return null ;
        }
    }

    /*
    선생님 나잇대
     */
    private BooleanExpression teacherAgeEq(Integer[] teacher_ages) {

        if (isEmpty(teacher_ages)) {
            return null;
        }
        int now = LocalDateTime.now().getYear() ;

        int min = Arrays.stream(teacher_ages).min(Comparator.naturalOrder()).orElse(0) ;
        int max = Arrays.stream(teacher_ages).max(Comparator.naturalOrder()).orElse(100)+10 ;

        return lesson.lectureTeacherList.any()
                .teacher.birth.subtract(now).multiply(-1)
                .between(min, max) ;
    }

    /*
    희망 수업 요일
     */
    private BooleanExpression weekDayEq(Integer[] choices) {
        EnumSet<Week> weeks;

        if (Arrays.stream(choices).anyMatch(e -> 1 <= e && e <= 3)) {
            weeks = EnumSet.of(Week.MONDAY, Week.TUESDAY, Week.WEDNESDAY, Week.THURSDAY, Week.FRIDAY);
        } else if (Arrays.stream(choices).anyMatch(e -> 4 <= e && e <= 6)) {
            weeks = EnumSet.of(Week.SATURDAY, Week.SUNDAY);
        } else {
            return null;
        }
        return lesson.lectureWeekDay.in(weeks.toArray(new Week[0]));
    }

    /*
    희망 수업 시간
     */
    private BooleanExpression classTimeEq(Integer[] choices) {
        List<BooleanExpression> conditions = Arrays.stream(choices)
                .map(choice -> {
                    if (choice == 1 || choice == 4) {
                        return lesson.lessonStartTime.hour().between(8, 12); // choice의 변환값
                    } else if (choice == 2 || choice == 5) {
                        return lesson.lessonStartTime.hour().between(12, 18);
                    } else {
                        return lesson.lessonStartTime.hour().between(18, 24);
                    }
                })
                .collect(Collectors.toList());

        // 각 조건을 or로 합친다
        return conditions.stream().reduce(BooleanExpression::or).orElse(null);
    }

    /*
    주소
    */

}
