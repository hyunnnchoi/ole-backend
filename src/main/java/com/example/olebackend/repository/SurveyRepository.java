package com.example.olebackend.repository;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.mapping.Likes;
import com.example.olebackend.domain.mapping.Survey;
import com.example.olebackend.repository.specification.SurveyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long>, SurveyRepositoryCustom {

    boolean existsByMemberAndLesson(Member member, Lesson lesson);

}
