package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.converter.NonMemberConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.NonMemberRepository;
import com.example.olebackend.web.dto.NonMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.LESSON_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class NonMemberService {
    private final NonMemberRepository nonMemberRepository;
    private final LessonRepository lessonRepository;

    public NonMember applyLesson(NonMemberRequest.ApplyDTO request, Long lessonId) {

        Lesson lesson=lessonRepository.findById(lessonId)
                .orElseThrow(() ->new GeneralException(LESSON_NOT_FOUND));


        NonMember nonMember = NonMemberConverter.toNonMember(request,lesson);

        return nonMemberRepository.save(nonMember);
    }

}
