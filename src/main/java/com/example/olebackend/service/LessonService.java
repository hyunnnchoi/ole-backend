package com.example.olebackend.service;

import com.example.olebackend.domain.Lesson;
import com.example.olebackend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;

    public Optional<Lesson> getLessonDetail(Long lessonId) {
       return lessonRepository.findById(lessonId);
    }
}
