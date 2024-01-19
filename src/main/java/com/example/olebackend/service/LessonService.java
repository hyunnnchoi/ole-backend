package com.example.olebackend.service;

import com.example.olebackend.apiPayLoad.exception.GeneralException;
import com.example.olebackend.domain.Lesson;
import com.example.olebackend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.example.olebackend.apiPayLoad.code.status.ErrorStatus.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;

    public Optional<Lesson> getLessonDetail(Long lessonId) {
        Optional<Lesson> lesson = lessonRepository.findById(lessonId);
        if (!lessonRepository.existsById(lessonId)) {
            throw new GeneralException(LESSON_NOT_FOUND);
        }
        return lesson;
    }
}
