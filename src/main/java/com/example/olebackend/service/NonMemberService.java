package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.converter.NonMemberConverter;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.domain.NonMember;
import com.example.olebackend.domain.enums.ApplicationStatus;
import com.example.olebackend.repository.LessonRepository;
import com.example.olebackend.repository.NonMemberRepository;
import com.example.olebackend.web.dto.NonMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;
import static com.example.olebackend.domain.enums.Completed.COMPLETED;

@Service
@RequiredArgsConstructor
public class NonMemberService {
    private final NonMemberRepository nonMemberRepository;
    private final LessonRepository lessonRepository;

    public NonMember applyLesson(NonMemberRequest.ApplyDTO request, Long lessonId) {
        String phoneNum=request.getPhoneNum();

        Lesson lesson=lessonRepository.findById(lessonId)
                .orElseThrow(() ->new GeneralException(LESSON_NOT_FOUND));

        if(nonMemberRepository.existsByLessonIdAndPhoneNum(lessonId, phoneNum)){
            throw new GeneralException(LESSON_APPLY_ALREADY_EXISTS);
        }

        ApplicationStatus applicationStatus = lesson.getPriceStatus() ? ApplicationStatus.REVIEWING : ApplicationStatus.APPROVED;


        NonMember nonMember = NonMemberConverter.toNonMember(request,lesson,applicationStatus);

        return nonMemberRepository.save(nonMember);
    }

    public List<NonMember> getApplication(NonMemberRequest.getPhoneNumDTO request) {
        String phoneNum=request.getPhoneNum();

        if (!nonMemberRepository.existsByPhoneNum(phoneNum)) {
            throw new GeneralException(NON_MEMBER_NOT_FOUND);
        }
        List<NonMember> nonMemberList= nonMemberRepository.findAllByPhoneNum(phoneNum);

        return nonMemberList;
    }

    public List<NonMember> getCompletedApplication(NonMemberRequest.getPhoneNumDTO request) {
        String phoneNum=request.getPhoneNum();

        //비회원 정보가 없을 때
        if (!nonMemberRepository.existsByPhoneNum(phoneNum)) {
            throw new GeneralException(NON_MEMBER_NOT_FOUND);
        }
        List<NonMember> nonMemberList= nonMemberRepository.findAllByPhoneNumAndAttendanceStatus(phoneNum,COMPLETED);

        //수강 완료한 수업이 없을 때
        if (nonMemberList.isEmpty()) {
            throw new GeneralException(COMPLETED_LESSON_NOT_FOUND);
        }

        return nonMemberList;
    }

    @Transactional
    public void cancelLesson(NonMemberRequest.getPhoneNumDTO request, Long lessonId) {
        String phoneNum=request.getPhoneNum();
        if (!nonMemberRepository.existsByPhoneNum(phoneNum)) {
            throw new GeneralException(NON_MEMBER_NOT_FOUND);
        }

        Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
        if (optionalLesson.isEmpty()) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }

        nonMemberRepository.removeByPhoneNumAndLessonId(phoneNum, lessonId);
    }



}
