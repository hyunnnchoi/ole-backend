package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.Member;
import com.example.olebackend.domain.mapping.Likes;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.LikeRepository;
import com.example.olebackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LessonRepository lessonRepository ;
    private final MemberRepository memberRepository ;
    private final LikeRepository likeRepository ;

    @Transactional
    public void addToWishlist(Long lessonId, Long memberId){

        Lesson lesson=lessonRepository.findById(lessonId)
                .orElseThrow(() ->new GeneralException(LESSON_NOT_FOUND));

        Member member=memberRepository.findById(memberId)
                .orElseThrow(() ->new GeneralException(MEMBER_NOT_FOUND));

        Likes createdLikes = Likes.builder().lesson(lesson).member(member).build();
        likeRepository.save(createdLikes) ;
    }
}
