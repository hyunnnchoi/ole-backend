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
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

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

    public Lesson getApplications(String phoneNum) {

        NonMember nonMember=nonMemberRepository.findByPhoneNum(phoneNum);
        if (!nonMemberRepository.existsByPhoneNum(phoneNum)) {
            throw new GeneralException(NON_MEMBER_NOT_FOUND);
        }
        Lesson lesson=nonMember.getLesson();

        return lesson;
    }

    @Transactional
    public Object cancelLesson(NonMemberRequest.cancelDTO request, Long lessonId) {
        NonMember nonMember = NonMemberConverter.toCancelDTO(request);
        String phoneNum=nonMember.getPhoneNum();
        if (nonMember == null) {
            throw new GeneralException(NON_MEMBER_NOT_FOUND);
        }

        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        if (optionalLesson.isEmpty()) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }

        nonMemberRepository.removeByPhoneNumAndLessonId(phoneNum, lessonId);
        return null;
    }



}
