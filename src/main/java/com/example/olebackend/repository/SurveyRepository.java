package com.example.olebackend.repository;

import com.example.olebackend.domain.mapping.Survey;
import com.example.olebackend.repository.specification.SurveyRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Long>, SurveyRepositoryCustom {

}
