package com.example.olebackend.repository;

import com.example.olebackend.domain.mapping.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {

    void removeByLessonIdAndMemberId(Long lessonId, Long memberId);
}
