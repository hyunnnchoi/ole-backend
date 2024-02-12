package com.example.olebackend.repository;

import com.example.olebackend.domain.enums.Completed;
import com.example.olebackend.domain.mapping.MemberApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberApplyRepository extends JpaRepository<MemberApply, Long> {
    Boolean existsByLessonIdAndMemberId(Long lessonId, Long memberId);

    void removeByLessonIdAndMemberId(Long lessonId, Long memberId);

    boolean existsByMemberId(Long memberId);

    List<MemberApply> findAllByMemberId(Long memberId);

    List<MemberApply> findAllByMemberIdAndAttendanceStatus(Long memberId, Completed completed);
}
