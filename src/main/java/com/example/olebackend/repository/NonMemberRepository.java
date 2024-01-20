package com.example.olebackend.repository;

import com.example.olebackend.domain.NonMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonMemberRepository extends JpaRepository<NonMember, Long> {



    NonMember findByPhoneNum(String phoneNum);

    boolean existsByPhoneNum(String phoneNum);

    void removeByPhoneNumAndLessonId(String phoneNum, Long lessonId);
}
